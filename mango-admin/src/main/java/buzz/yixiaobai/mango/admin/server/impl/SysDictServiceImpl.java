package buzz.yixiaobai.mango.admin.server.impl;

import buzz.yixiaobai.mango.admin.dao.SysDictMapper;
import buzz.yixiaobai.mango.admin.model.SysDict;
import buzz.yixiaobai.mango.admin.server.ISysDictService;
import buzz.yixiaobai.mango.core.page.MyBatisPageHelper;
import buzz.yixiaobai.mango.core.page.PageRequest;
import buzz.yixiaobai.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@Service
public class SysDictServiceImpl implements ISysDictService {

    @Resource
    private SysDictMapper sysDictMapper;

    @Override
    public List<SysDict> findByLabel(String label) {
        return sysDictMapper.findByLabel(label);
    }

    @Override
    public int save(SysDict record) {
        // 当不存在这条记录时，插入这条记录
        if(record.getId() == null || record.getId() == 0){
            return sysDictMapper.insertSelective(record);
        }
        // 否则更新记录
        return sysDictMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 通过ID删除单条记录
     * @param record
     * @return
     */
    @Override
    public int delete(SysDict record) {
        return sysDictMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 删除多条记录
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysDict> records) {
        for(SysDict sysDict : records){
            delete(sysDict);
        }
        return 1;
    }

    /**
     * 通过ID来查询单条记录
     * @param id
     * @return
     */
    @Override
    public SysDict findById(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     * @param pageRequest 自定义：统一分页查询请求
     * @return
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("label");
        if(label != null){
            return MyBatisPageHelper.findPage(pageRequest, sysDictMapper, "findPageByLabel" ,label);
        }
        return MyBatisPageHelper.findPage(pageRequest, sysDictMapper);
    }
}
