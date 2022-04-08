package buzz.yixiaobai.mango.admin.server;


import buzz.yixiaobai.mango.admin.model.SysMenu;
import buzz.yixiaobai.mango.core.service.CurdService;

import java.util.List;

/**
 * <p>
 * 机构管理 服务类
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface ISysMenuService extends CurdService<SysMenu> {

    /**
     * 查询菜单树，用户ID和用户名为空则查询全部
     * @param user
     * @param menuType
     * @return
     */
    List<SysMenu> findTree(String user, int menuType);

    /**
     * 根据用户名查找菜单列表
     * @param userName
     * @return
     */
    List<SysMenu> findByUser(String userName);
}
