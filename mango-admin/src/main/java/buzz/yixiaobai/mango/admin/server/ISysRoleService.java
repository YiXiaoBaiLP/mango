package buzz.yixiaobai.mango.admin.server;


import buzz.yixiaobai.mango.admin.model.SysMenu;
import buzz.yixiaobai.mango.admin.model.SysRole;
import buzz.yixiaobai.mango.admin.model.SysRoleMenu;
import buzz.yixiaobai.mango.core.service.CurdService;

import java.util.List;

/**
 * <p>
 * 角色管理 服务类
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface ISysRoleService extends CurdService<SysRole> {

    /**
     * 查询全部
     * @return
     */
    List<SysRole> findAll();

    /**
     * 查询角色菜单集合
     * @param roleId
     * @return
     */
    List<SysMenu> findRoleMenus(Long roleId);

    /**
     * 保存角色菜单
     * @param records
     * @return
     */
    int saveRoleMenus(List<SysRoleMenu> records);

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    List<SysRole> findByName(String name);
}
