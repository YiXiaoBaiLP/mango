package buzz.yixiaobai.mango.admin.server;


import buzz.yixiaobai.mango.admin.model.SysDept;
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
public interface ISysDeptService extends CurdService<SysDept> {

    /**
     * 查询机构数
     * @return
     */
    List<SysDept> findTree();
}
