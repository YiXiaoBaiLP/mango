package buzz.yixiaobai.mango.admin.controller;

import buzz.yixiaobai.mango.admin.server.ISysUserService;
import buzz.yixiaobai.mango.core.http.HttpResult;
import buzz.yixiaobai.mango.core.page.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户管理 前端控制器
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@RestController
@RequestMapping("user")
public class SysUserController {

    @Resource
    private ISysUserService sysUserService;

    @GetMapping("/findAll")
    public Object findAll(){
        return sysUserService.findAll();
    }

    /**
     * 分页查询
     * @return
     */
    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(sysUserService.findPage(pageRequest));
    }
}
