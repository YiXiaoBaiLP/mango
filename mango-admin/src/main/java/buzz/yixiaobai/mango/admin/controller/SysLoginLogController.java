package buzz.yixiaobai.mango.admin.controller;

import buzz.yixiaobai.mango.admin.model.SysLoginLog;
import buzz.yixiaobai.mango.admin.server.ISysLoginLogService;
import buzz.yixiaobai.mango.core.http.HttpResult;
import buzz.yixiaobai.mango.core.page.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统登录日志 前端控制器
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@RestController
@RequestMapping("loginLog")
public class SysLoginLogController {

    @Resource
    private ISysLoginLogService sysLoginLogService;

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(sysLoginLogService.findPage(pageRequest));
    }

    @PostMapping("/delete")
    public HttpResult delete(List<SysLoginLog> records){
        return HttpResult.ok(sysLoginLogService.delete(records));
    }
}
