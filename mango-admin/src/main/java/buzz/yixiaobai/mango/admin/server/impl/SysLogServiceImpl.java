package buzz.yixiaobai.mango.admin.server.impl;

import buzz.yixiaobai.mango.admin.dao.SysLogMapper;
import buzz.yixiaobai.mango.admin.model.SysLog;
import buzz.yixiaobai.mango.admin.server.ISysLogService;
import buzz.yixiaobai.mango.core.page.MyBatisPageHelper;
import buzz.yixiaobai.mango.core.page.PageRequest;
import buzz.yixiaobai.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统操作日志表 服务实现类
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@Service
public class SysLogServiceImpl implements ISysLogService {

    @Resource
    private SysLogMapper sysLogMapper;

    /**
     * 保存或更新
     * @param record
     * @return
     */
    @Override
    public int save(SysLog record) {
        if(record.getId() == null || record.getId() == 0){
            return sysLogMapper.insert(record);
        }
        return sysLogMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 删除
     * @param record
     * @return
     */
    @Override
    public int delete(SysLog record) {
        return sysLogMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysLog> records) {
        for(SysLog sysLog : records){
            delete(sysLog);
        }
        return 1;
    }

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    @Override
    public SysLog findById(Long id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     * @param pageRequest 自定义：统一分页查询请求
     * @return
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("userName");
        if(label != null){
            return MyBatisPageHelper.findPage(pageRequest, sysLogMapper, "findPageByUserName" ,label);
        }
        return MyBatisPageHelper.findPage(pageRequest, sysLogMapper);
    }
}
