package buzz.yixiaobai.mango.admin.controller;

import buzz.yixiaobai.mango.admin.model.SysConfig;
import buzz.yixiaobai.mango.admin.server.ISysConfigService;
import buzz.yixiaobai.mango.core.http.HttpResult;
import buzz.yixiaobai.mango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统配置表 前端控制器
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@RestController
@RequestMapping("config")
public class SysConfigController {

    @Resource
    private ISysConfigService sysConfigServer;

    @PreAuthorize("hasAuthority('sys:config:add') AND hasAuthority('sys:config:edit')")
    @PostMapping("/save")
    public HttpResult save(@RequestBody SysConfig record){
        return HttpResult.ok(sysConfigServer.save(record));
    }

    /**
     * 删除
     * @param records
     * @return
     */
    @PreAuthorize("hasAuthority('sys:config:delete')")
    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysConfig> records){
        return HttpResult.ok(sysConfigServer.delete(records));
    }

    /**
     * 分页查询
     * @param pageRequest
     * @return
     */
    @PreAuthorize("hasAuthority('sys:config:view')")
    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(sysConfigServer.findPage(pageRequest));
    }

    /**
     * 通过label分页查询
     * @param label
     * @return
     */
    @PreAuthorize("hasAuthority('sys:config:view')")
    @PostMapping("/findByLabel")
    public HttpResult findByLabel(@RequestBody String label){
        return HttpResult.ok(sysConfigServer.findByLabel(label));
    }
}
