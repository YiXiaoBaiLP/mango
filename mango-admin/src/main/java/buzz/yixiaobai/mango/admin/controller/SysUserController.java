package buzz.yixiaobai.mango.admin.controller;

import buzz.yixiaobai.mango.admin.constant.SysConstants;
import buzz.yixiaobai.mango.admin.model.SysUser;
import buzz.yixiaobai.mango.admin.server.ISysUserService;
import buzz.yixiaobai.mango.admin.util.PasswordUtils;
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

    /**
     * 新增用户
     * @param record
     * @return
     */
    @PostMapping("/save")
    public HttpResult save(@RequestBody SysUser record) {
        SysUser user = sysUserService.findById(record.getId());
        if(user != null){
            if(SysConstants.ADMIN.equalsIgnoreCase(user.getName())){
                return HttpResult.error("超级管理员不允许修改！");
            }
        }
        if(record.getPassword() != null){
            String salt = PasswordUtils.getSalt();
            if(user == null){
                // 新增用户
                if(sysUserService.findByName(record.getName()) != null){
                    return HttpResult.error("用户已经存在！");
                }
                String password = PasswordUtils.encode(record.getPassword(), salt);
                record.setSalt(salt);
                record.setPassword(password);
            }else{
                // 修改用户，且修改密码
                if(!record.getPassword().equals(user.getPassword())){
                    String password = PasswordUtils.encode(record.getPassword(), salt);
                    record.setSalt(salt);
                    record.setPassword(password);
                }
            }
        }
        return HttpResult.ok(sysUserService.save(record));
    }

    /**
     * 根据用户名称查询
     * @param name
     * @return
     */
    @GetMapping("/findByName")
    public HttpResult findByName(@RequestParam String name){
        return HttpResult.ok(sysUserService.findByName(name));
    }

    /**
     * 根据用户名称查询权限
     * @param name
     * @return
     */
    @GetMapping("/findPermissions")
    public HttpResult findPermissions(@RequestParam String name){
        return HttpResult.ok(sysUserService.findPermissions(name));
    }

    /**
     * 根据用户Id查询角色
     * @param userId
     * @return
     */
    @GetMapping("findUserRoles")
    public HttpResult findUserRoles(@RequestParam Long userId){
        return HttpResult.ok(sysUserService.findUserRoles(userId));
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
