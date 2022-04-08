package buzz.yixiaobai.mango.admin.server.impl;

import buzz.yixiaobai.mango.admin.dao.SysRoleMapper;
import buzz.yixiaobai.mango.admin.dao.SysUserMapper;
import buzz.yixiaobai.mango.admin.dao.SysUserRoleMapper;
import buzz.yixiaobai.mango.admin.model.SysMenu;
import buzz.yixiaobai.mango.admin.model.SysRole;
import buzz.yixiaobai.mango.admin.model.SysUser;
import buzz.yixiaobai.mango.admin.model.SysUserRole;
import buzz.yixiaobai.mango.admin.server.ISysMenuService;
import buzz.yixiaobai.mango.admin.server.ISysUserService;
import buzz.yixiaobai.mango.core.page.MyBatisPageHelper;
import buzz.yixiaobai.mango.core.page.PageRequest;
import buzz.yixiaobai.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户管理 服务实现类
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@Service
public class SysUserServiceImpl implements ISysUserService{
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private ISysMenuService sysMenuService;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public int save(SysUser record) {
        Long id = null;
        if(record.getId() == null || record.getId() == 0){
            // 新增用户
            sysUserMapper.insertSelective(record);
            id = record.getId();
        }else{
            // 更新用户信息
            sysUserMapper.updateByPrimaryKeySelective(record);
        }
        // 新增用户角色
        if(id != null && id == 0){
            return 1;
        }

        if(id != null){
            for(SysUserRole sysUserRole : record.getUserRoles()){
                sysUserRole.setUserId(id);
            }
        }else{
            sysUserRoleMapper.deleteByUserId(record.getId());
        }

        for(SysUserRole sysUserRole : record.getUserRoles()){
            sysUserRoleMapper.insertSelective(sysUserRole);
        }
        return 1;
    }

    /**
     * 删除
     * @param record
     * @return
     */
    @Override
    public int delete(SysUser record) {
        return sysUserMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysUser> records) {
        for(SysUser sysUser : records){
            delete(sysUser);
        }
        return 1;
    }

    /**
     * 通过用户id查询
     * @param id
     * @return
     */
    @Override
    public SysUser findById(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     * @param pageRequest 自定义：统一分页查询请求
     * @return
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        PageResult pageResult = null;
        Object name = pageRequest.getParam("name");
        Object email = pageRequest.getParam("email");
        if(name != null){
            if(email != null){
                pageResult = MyBatisPageHelper.findPage(pageRequest, sysUserMapper, "findPageByNameAndEmail", name, email);
            }else{
                pageResult = MyBatisPageHelper.findPage(pageRequest, sysUserMapper, "findPageByName", name, email);
            }
        } else {
            pageResult = MyBatisPageHelper.findPage(pageRequest, sysUserMapper);
        }

        //加载用户角色信息
        findUserRoles(pageResult);
        return pageResult;
    }

    /**
     * 加载用户角色
     * @param pageResult
     */
    private void findUserRoles(PageResult pageResult){
        List<?> content = pageResult.getContent();
        for(Object obj : content){
            SysUser sysUser = (SysUser) obj;
            List<SysUserRole> userRoels = findUserRoles(sysUser.getId());
            sysUser.setUserRoles(userRoels);
            sysUser.setRoleName(getRoleNames(userRoels));
        }
    }

    /**
     * 获取用户角色名称
     * @param userRoles
     * @return
     */
    private String getRoleNames(List<SysUserRole> userRoles){
        StringBuffer sb = new StringBuffer();
        for(Iterator<SysUserRole> iter = userRoles.iterator(); iter.hasNext();) {
            SysUserRole userRole = iter.next();
            SysRole sysRole = sysRoleMapper.selectByPrimaryKey(userRole.getRoleId());
            if(sysRole == null){
                continue;
            }
            sb.append(sysRole.getRemark());
            if(iter.hasNext()){
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    /**
     * 通过用户名称查询
     * @param name
     * @return
     */
    @Override
    public SysUser findByName(String name) {
        return sysUserMapper.findByName(name);
    }

    /**
     * 查找权限
     * @param name
     * @return
     */
    @Override
    public Set<String> findPermissions(String name) {
        Set<String> perms = new HashSet<>();
        List<SysMenu> sysMenus = sysMenuService.findByUser(name);
        for(SysMenu sysMenu : sysMenus){
            if(sysMenu.getPerms() != null && !"".equals(sysMenu.getPerms())){
                perms.add(sysMenu.getPerms());
            }
        }
        return perms;
    }

    /**
     * 查找用户角色
     * @param userId
     * @return
     */
    @Override
    public List<SysUserRole> findUserRoles(Long userId) {
        return sysUserRoleMapper.findUserRoles(userId);
    }

    /**
     * 导出用户Excel文件
     * @param pageRequest
     * @return
     */
    @Override
    public File createUserExcelFile(PageRequest pageRequest) {
        return null;
    }
}
