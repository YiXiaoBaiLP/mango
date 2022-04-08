package buzz.yixiaobai.mango.admin.dao;


import buzz.yixiaobai.mango.admin.model.SysLog;
import buzz.yixiaobai.mango.admin.model.SysLoginLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统登录日志 Mapper 接口
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface SysLoginLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysLoginLog sysLog);

    int insertSelective(SysLoginLog sysLog);

    SysLoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLoginLog sysLog);

    int updateByPrimaryKey(SysLoginLog sysLog);

    List<SysLog> findPage();

    List<SysLog> findByUserName(@Param("userName") String userName);

    List<SysLog> findPageStatus(@Param("status") String status);
}
