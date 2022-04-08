package buzz.yixiaobai.mango.admin.server.impl;

import buzz.yixiaobai.mango.admin.constant.SysConstants;
import buzz.yixiaobai.mango.admin.dao.SysMenuMapper;
import buzz.yixiaobai.mango.admin.model.SysMenu;
import buzz.yixiaobai.mango.admin.server.ISysMenuService;
import buzz.yixiaobai.mango.core.page.MyBatisPageHelper;
import buzz.yixiaobai.mango.core.page.PageRequest;
import buzz.yixiaobai.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 机构管理 服务实现类
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@Service
public class SysMenuServiceImpl implements ISysMenuService {

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> findTree(String user, int menuType) {
        List<SysMenu> sysMenus = new ArrayList<>();
        List<SysMenu> menus = sysMenuMapper.findAll();
        for(SysMenu menu : menus){
            if(menu.getParentId() == null || menu.getParentId() == 0){
                menu.setLevel(0);
                if(!exists(sysMenus, menu)){
                    sysMenus.add(menu);
                }
            }
        }
        sysMenus.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
        findChildren(sysMenus, menus, menuType);
        return sysMenus;
    }

    /**
     * 通过用户查询
     * @param userName
     * @return
     */
    @Override
    public List<SysMenu> findByUser(String userName) {
        if(userName == null || "".equals(userName) || SysConstants.ADMIN.equalsIgnoreCase(userName)){
            return sysMenuMapper.findAll();
        }
        return sysMenuMapper.findByUserName(userName);
    }

    private List<SysMenu> findChildren(List<SysMenu> sysMenus, List<SysMenu> menus, int menuType){
        for(SysMenu sysMenu : sysMenus){
            List<SysMenu> children = new ArrayList<>();
            for(SysMenu menu : menus) {
                if(menuType == 1 && menu.getType() == 2){
                    // 如果是获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
                    continue;
                }
                if(sysMenu.getId() != null && sysMenu.getId().equals(menu.getParentId())) {
                    menu.setParentName(sysMenu.getName());
                    menu.setLevel(sysMenu.getLevel() + 1);
                    if(!exists(children, menu)){
                        children.add(menu);
                    }
                }
            }
            sysMenu.setChildren(children);
            children.sort((o1, o2)-> o1.getOrderNum().compareTo(o2.getOrderNum()));
            findChildren(children, menus, menuType);
        }
        return null;
    }

    /**
     * 新增、更新
     * @param record
     * @return
     */
    @Override
    public int save(SysMenu record) {
        if(record.getIcon() == null || record.getId() == 0){
            return sysMenuMapper.insertSelective(record);
        }

        if(record.getParentId() == null){
            record.setParentId(0L);
        }
        return sysMenuMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 删除
     * @param record
     * @return
     */
    @Override
    public int delete(SysMenu record) {
        return sysMenuMapper.deleteByPrimaryKey(record.getId());
    }

    /**
     * 批量删除
     * @param records
     * @return
     */
    @Override
    public int delete(List<SysMenu> records) {
        for(SysMenu sysMenu : records){
            delete(sysMenu);
        }
        return 1;
    }

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    @Override
    public SysMenu findById(Long id) {
        return sysMenuMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询
     * @param pageRequest 自定义：统一分页查询请求
     * @return
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MyBatisPageHelper.findPage(pageRequest, sysMenuMapper);
    }

    private boolean exists(List<SysMenu> sysMenus, SysMenu sysMenu){
        boolean exist = false;
        for(SysMenu menu : sysMenus){
            if(menu.getId().equals(sysMenu.getId())){
                exist = true;
            }
        }
        return exist;
    }
}
