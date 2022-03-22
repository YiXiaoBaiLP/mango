package buzz.yixiaobai.mango.admin.dao;


import buzz.yixiaobai.mango.admin.model.SysRole;

/**
 * <p>
 * 角色管理 Mapper 接口
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface SysRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysRole sysRole);

    int insertSelective(SysRole sysRole);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole sysRole);

    int updateByPrimaryKey(SysRole sysRole);

}
