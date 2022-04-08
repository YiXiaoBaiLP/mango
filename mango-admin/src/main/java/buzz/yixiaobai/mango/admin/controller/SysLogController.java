package buzz.yixiaobai.mango.admin.controller;

import buzz.yixiaobai.mango.admin.model.SysLog;
import buzz.yixiaobai.mango.admin.server.ISysLogService;
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
 * 系统操作日志表 前端控制器
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@RestController
@RequestMapping("log")
public class SysLogController {

    @Resource
    private ISysLogService sysLogService;

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest){
        return  HttpResult.ok(sysLogService.findPage(pageRequest));
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysLog> recodes){
        return HttpResult.ok(sysLogService.delete(recodes));
    }

}
