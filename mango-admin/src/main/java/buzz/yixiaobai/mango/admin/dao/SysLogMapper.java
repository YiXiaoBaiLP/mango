package buzz.yixiaobai.mango.admin.dao;


import buzz.yixiaobai.mango.admin.model.SysLog;

/**
 * <p>
 * 系统操作日志表 Mapper 接口
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface SysLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysLog sysLog);

    int insertSelective(SysLog sysLog);

    SysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLog sysLog);

    int updateByPrimaryKey(SysLog sysLog);
}
