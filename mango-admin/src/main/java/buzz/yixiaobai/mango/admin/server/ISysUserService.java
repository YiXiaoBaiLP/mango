package buzz.yixiaobai.mango.admin.server;


import buzz.yixiaobai.mango.admin.model.SysUser;
import buzz.yixiaobai.mango.admin.model.SysUserRole;
import buzz.yixiaobai.mango.core.page.PageRequest;
import buzz.yixiaobai.mango.core.service.CurdService;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户管理 服务类
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface ISysUserService extends CurdService<SysUser> {

    /**
     * 通过用户名称查询
     * @param name
     * @return
     */
    SysUser findByName(String name);

    /**
     * 查找用户的菜单权限表示集合
     * @param name
     * @return
     */
    Set<String> findPermissions(String name);

    /**
     * 查找用户的角色集合
     * @param userId
     * @return
     */
    List<SysUserRole> findUserRoles(Long userId);

    /**
     * 生成用户信息Excel文件
     * @param pageRequest 要导出的分页查询参数
     * @return
     */
    File createUserExcelFile(PageRequest pageRequest);
}
