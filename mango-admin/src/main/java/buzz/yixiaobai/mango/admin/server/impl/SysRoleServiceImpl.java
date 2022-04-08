package buzz.yixiaobai.mango.admin.server.impl;

import buzz.yixiaobai.mango.admin.constant.SysConstants;
import buzz.yixiaobai.mango.admin.dao.SysMenuMapper;
import buzz.yixiaobai.mango.admin.dao.SysRoleMapper;
import buzz.yixiaobai.mango.admin.dao.SysRoleMenuMapper;
import buzz.yixiaobai.mango.admin.model.SysMenu;
import buzz.yixiaobai.mango.admin.model.SysRole;
import buzz.yixiaobai.mango.admin.model.SysRoleMenu;
import buzz.yixiaobai.mango.admin.server.ISysRoleService;
import buzz.yixiaobai.mango.core.page.MyBatisPageHelper;
import buzz.yixiaobai.mango.core.page.PageRequest;
import buzz.yixiaobai.mango.core.page.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色管理 服务实现类
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Resource
    private SysMenuMapper sysMenueMapper;

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<SysRole> findAll() {
        return sysRoleMapper.findAll();
    }

    @Override
    public List<SysMenu> findRoleMenus(Long roleId) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
        if(SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())){
            // 如果是超级管理员，则返回全部菜单
            return sysMenueMapper.findAll();
        }
        return sysMenueMapper.findRoleMenu(roleId);
    }

    @Transactional
    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {
        if(records == null || records.isEmpty()){
            return 1;
        }
        Long roleId = records.get(0).getId();
        sysRoleMapper.deleteByPrimaryKey(roleId);
        for(SysRoleMenu sysRoleMenu : records){
            sysRoleMenuMapper.insertSelective(sysRoleMenu);
        }
        return 1;
    }

    @Override
    public List<SysRole> findByName(String name) {
        return sysRoleMapper.findByName(name);
    }

    /**
     * 条件插入或者更新
     * @param record
     * @return
     */
    @Override
    public int save(SysRole record) {
        if(record.getId() == null || record.getId() == 0){
            sysRoleMapper.insertSelective(record);
        }
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 通过ID删除
     * @param record
     * @return
     */
    @Override
    public int delete(SysRole record) {
        return sysRoleMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysRole> records) {
        for(SysRole sysRole : records){
            delete(sysRole);
        }
        return 1;
    }

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    @Override
    public SysRole findById(Long id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     * @param pageRequest 自定义：统一分页查询请求
     * @return
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("name");
        if(label != null){
            return MyBatisPageHelper.findPage(pageRequest, sysRoleMapper, "findPageByName", label);
        }
        return MyBatisPageHelper.findPage(pageRequest, sysRoleMapper);
    }

    public SysRoleMapper getSysRoleMapper(){
        return this.sysRoleMapper;
    }

    public void setSysRoleMapper(SysRoleMapper sysRoleMapper){
        this.sysRoleMapper = sysRoleMapper;
    }
}
