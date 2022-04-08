package buzz.yixiaobai.mango.admin.controller;

import buzz.yixiaobai.mango.admin.model.SysMenu;
import buzz.yixiaobai.mango.admin.server.ISysMenuService;
import buzz.yixiaobai.mango.core.http.HttpResult;
import buzz.yixiaobai.mango.core.page.MyBatisPageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 机构管理 前端控制器
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@RestController
@RequestMapping("menu")
public class SysMenuController {

    @Resource
    private ISysMenuService sysMenuService;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysMenu sysMenu){
        return HttpResult.ok(sysMenuService.save(sysMenu));
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysMenu> records){
        return HttpResult.ok(sysMenuService.delete(records));
    }

    @GetMapping("/findNavTree")
    public HttpResult findNavTree(@RequestParam String userName){
        return HttpResult.ok(sysMenuService.findTree(userName, 1));
    }

    @GetMapping("/findMenuTree")
    public HttpResult findMenuTree(){
        return HttpResult.ok(sysMenuService.findTree(null, 0));
    }
}
