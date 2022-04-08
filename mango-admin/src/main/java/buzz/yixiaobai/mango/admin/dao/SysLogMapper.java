package buzz.yixiaobai.mango.admin.dao;


import buzz.yixiaobai.mango.admin.model.SysLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 分页查询
     * @return
     */
    List<SysLog> findPage();

    /**
     * 通过userName分页查询
     * @param userName
     * @return
     */
    List<SysLog> findPageByUserName(@Param("userName") String userName);
}
