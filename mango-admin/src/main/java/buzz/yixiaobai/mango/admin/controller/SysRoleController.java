package buzz.yixiaobai.mango.admin.controller;

import buzz.yixiaobai.mango.admin.constant.SysConstants;
import buzz.yixiaobai.mango.admin.dao.SysRoleMapper;
import buzz.yixiaobai.mango.admin.model.SysRole;
import buzz.yixiaobai.mango.admin.model.SysRoleMenu;
import buzz.yixiaobai.mango.admin.server.ISysRoleService;
import buzz.yixiaobai.mango.core.http.HttpResult;
import buzz.yixiaobai.mango.core.page.PageRequest;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色管理 前端控制器
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@RestController
@RequestMapping("role")
public class SysRoleController {

    @Resource
    private ISysRoleService sysRoleService;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysRole record) {
        SysRole role = sysRoleService.findById(record.getId());
        if(role != null){
            if (SysConstants.ADMIN.equalsIgnoreCase(role.getName())) {
                return HttpResult.error("超级管理员不允许修改！");
            }
        }
        // 新增角色
        if((record.getId() == null || record.getId() == 0) && !sysRoleService.findByName(record.getName()).isEmpty()){
            return HttpResult.error("角色名已经存在！");
        }
        return HttpResult.ok(sysRoleService.save(record));
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysRole> records){
        return HttpResult.ok(sysRoleService.delete(records));
    }

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(sysRoleService.findPage(pageRequest));
    }

    @GetMapping("/findAll")
    public HttpResult findAll(){
        return HttpResult.ok(sysRoleService.findAll());
    }

    @PostMapping("/findRoleMenus")
    public HttpResult findRoleMenus(@RequestParam Long roleId){
        return HttpResult.ok(sysRoleService.findRoleMenus(roleId));
    }

    @PostMapping("/saveRoleMenus")
    public HttpResult saveRoleMenus(@RequestBody List<SysRoleMenu> records){
        for(SysRoleMenu sysRoleMenu : records){
            SysRole sysRole = sysRoleMapper.selectByPrimaryKey(sysRoleMenu.getRoleId());
            if(SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())){
                // 如果是超级管理员，不允许修改
                return HttpResult.error("超级管理员拥有所有的菜单权限，不允许修改");
            }
        }
        return HttpResult.ok(sysRoleService.saveRoleMenus(records));
    }
}
