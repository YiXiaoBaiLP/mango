package buzz.yixiaobai.mango.admin.server.impl;

import buzz.yixiaobai.mango.admin.dao.SysDeptMapper;
import buzz.yixiaobai.mango.admin.model.SysDept;
import buzz.yixiaobai.mango.admin.server.ISysDeptService;
import buzz.yixiaobai.mango.core.page.MyBatisPageHelper;
import buzz.yixiaobai.mango.core.page.PageRequest;
import buzz.yixiaobai.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 机构管理 服务实现类
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@Service
public class SysDeptServiceImpl implements ISysDeptService {

    @Resource
    private SysDeptMapper sysDeptMapper;

    /**
     * 保存
     * @param record
     * @return
     */
    @Override
    public int save(SysDept record) {
        if(record.getId() == null || record.getId() == 0){
            return sysDeptMapper.insert(record);
        }
        return sysDeptMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 删除一条匹配的记录
     * @param record
     * @return
     */
    @Override
    public int delete(SysDept record) {
        return sysDeptMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysDept> records) {
        for(SysDept sysDept : records){
            delete(sysDept);
        }
        return 1;
    }

    @Override
    public SysDept findById(Long id) {
        return sysDeptMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     * @param pageRequest 自定义：统一分页查询请求
     * @return
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MyBatisPageHelper.findPage(pageRequest, sysDeptMapper);
    }

    /**
     * 查询部门树
     * @return
     */
    @Override
    public List<SysDept> findTree() {
        List<SysDept> sysDepts = new ArrayList<>();
        List<SysDept> detps = sysDeptMapper.findAll();
        for(SysDept dept : detps){
            if (dept.getParentId() == null || dept.getParentId() == 0) {
                dept.setLevel(0);
                sysDepts.add(dept);
            }
        }
        findChildren(sysDepts, detps);
        return sysDepts;
    }

    /**
     * 递归查询
     * @param sysDepts
     * @param depts
     */
    private void findChildren(List<SysDept> sysDepts, List<SysDept> depts){
        for(SysDept sysDept : sysDepts){
            List<SysDept> children = new ArrayList<>();
            for(SysDept dept : depts){
                if(sysDept.getId() != null && sysDept.getId().equals(dept.getParentId())){
                    dept.setParentName(dept.getName());
                    dept.setLevel(sysDept.getLevel() + 1);
                    children.add(dept);
                }
            }
            sysDept.setChildren(children);
            findChildren(children, depts);
        }
    }
}
