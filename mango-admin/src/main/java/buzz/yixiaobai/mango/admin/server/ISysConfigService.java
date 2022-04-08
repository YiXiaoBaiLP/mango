package buzz.yixiaobai.mango.admin.server;

import buzz.yixiaobai.mango.admin.model.SysConfig;
import buzz.yixiaobai.mango.core.service.CurdService;

import java.util.List;

/**
 * <p>
 * 系统配置表 服务类
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface ISysConfigService extends CurdService<SysConfig> {

    List<SysConfig> findByLabel(String label);

}
