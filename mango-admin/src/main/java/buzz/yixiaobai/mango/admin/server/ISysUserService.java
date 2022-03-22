package buzz.yixiaobai.mango.admin.server;


import buzz.yixiaobai.mango.admin.model.SysUser;
import buzz.yixiaobai.mango.core.service.CurdService;

import java.util.List;

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
     * 查询全部
     * @return
     */
    List<SysUser> findAll();
}
