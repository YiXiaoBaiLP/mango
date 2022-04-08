package buzz.yixiaobai.mango.admin.server.impl;

import buzz.yixiaobai.mango.admin.dao.SysLoginLogMapper;
import buzz.yixiaobai.mango.admin.model.SysLoginLog;
import buzz.yixiaobai.mango.admin.server.ISysLoginLogService;
import buzz.yixiaobai.mango.core.page.MyBatisPageHelper;
import buzz.yixiaobai.mango.core.page.PageRequest;
import buzz.yixiaobai.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统登录日志 服务实现类
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@Service
public class SysLoginLogServiceImpl implements ISysLoginLogService {

    @Resource
    private SysLoginLogMapper sysLoginLogMapper;

    /**
     * 新增、更新
     * @param record
     * @return
     */
    @Override
    public int save(SysLoginLog record) {
        if(record.getId() == null || record.getId() == 0){
            return sysLoginLogMapper.insert(record);
        }
        return sysLoginLogMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 删除
     * @param record
     * @return
     */
    @Override
    public int delete(SysLoginLog record) {
        return sysLoginLogMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 批量删除
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysLoginLog> records) {
        for(SysLoginLog sysLoginLog : records){
            delete(sysLoginLog);
        }
        return 1;
    }

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    @Override
    public SysLoginLog findById(Long id) {
        return sysLoginLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     * @param pageRequest 自定义：统一分页查询请求
     * @return
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object userName = pageRequest.getParam("userName");
        if (userName != null) {
            return MyBatisPageHelper.findPage(pageRequest, sysLoginLogMapper, "findByUserName", userName);
        }
        Object status = pageRequest.getParam("status");
        if(status != null){
            return MyBatisPageHelper.findPage(pageRequest, sysLoginLogMapper, "findByUserStatus", status);
        }
        return MyBatisPageHelper.findPage(pageRequest, sysLoginLogMapper);
    }
}
