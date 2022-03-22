package buzz.yixiaobai.mango.admin.server;

import buzz.yixiaobai.mango.admin.model.SysDict;
import buzz.yixiaobai.mango.core.service.CurdService;

import java.util.List;

/**
 * <p>
 * 字典管理
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface ISysDictService extends CurdService<SysDict> {

    List<SysDict> findByLabel(String label);
}
