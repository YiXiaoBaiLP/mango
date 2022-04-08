package buzz.yixiaobai.mango.admin.server.impl;

import buzz.yixiaobai.mango.admin.dao.SysConfigMapper;
import buzz.yixiaobai.mango.admin.model.SysConfig;
import buzz.yixiaobai.mango.admin.server.ISysConfigService;
import buzz.yixiaobai.mango.core.page.MyBatisPageHelper;
import buzz.yixiaobai.mango.core.page.PageRequest;
import buzz.yixiaobai.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统配置表 服务实现类
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@Service
public class SysConfigServiceImpl implements ISysConfigService {

    @Resource
    private SysConfigMapper sysConfigMapper;

    @Override
    public List<SysConfig> findByLabel(String label) {
        return sysConfigMapper.findByLabel(label);
    }

    @Override
    public int save(SysConfig record) {
        if(record.getId() == null || record.getId() == 0){
            return sysConfigMapper.insert(record);
        }
        return sysConfigMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据主键删除
     * @param record
     * @return
     */
    @Override
    public int delete(SysConfig record) {
        return sysConfigMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 根据主键批量删除
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysConfig> records) {
        for(SysConfig sysConfig : records){
            delete(sysConfig);
        }
        return 1;
    }

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    @Override
    public SysConfig findById(Long id) {
        return sysConfigMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     * @param pageRequest 自定义：统一分页查询请求
     * @return
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("label");
        if(null != label){
            return MyBatisPageHelper.findPage(pageRequest, sysConfigMapper, "findPageByLabel", label);
        }
        return MyBatisPageHelper.findPage(pageRequest, sysConfigMapper);
    }
}
