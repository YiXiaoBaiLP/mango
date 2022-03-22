package buzz.yixiaobai.mango.admin.dao;


import buzz.yixiaobai.mango.admin.model.SysRoleMenu;

/**
 * <p>
 * 角色菜单 Mapper 接口
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface SysRoleMenuMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysRoleMenu sysRoleMenu);

    int insertSelective(SysRoleMenu sysRoleMenu);

    SysRoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleMenu sysRoleMenu);

    int updateByPrimaryKey(SysRoleMenu sysRoleMenu);
}
