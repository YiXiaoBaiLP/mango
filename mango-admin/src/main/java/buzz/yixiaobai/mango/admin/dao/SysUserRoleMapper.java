package buzz.yixiaobai.mango.admin.dao;


import buzz.yixiaobai.mango.admin.model.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户角色 Mapper 接口
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface SysUserRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole sysUserRole);

    int insertSelective(SysUserRole sysUserRole);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRole sysUserRole);

    int updateByPrimaryKey(SysUserRole sysUserRole);

    List<SysUserRole> findUserRoles(@Param("userId") Long userId);

    int deleteByUserId(@Param("userId") Long userId);

}
