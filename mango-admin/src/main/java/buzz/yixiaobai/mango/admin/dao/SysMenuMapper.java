package buzz.yixiaobai.mango.admin.dao;


import buzz.yixiaobai.mango.admin.model.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 机构管理 Mapper 接口
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface SysMenuMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysMenu sysMenu);

    int insertSelective(SysMenu sysMenu);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu sysMenu);

    int updateByPrimaryKey(SysMenu sysMenu);

    /**
     * 分页查询
     * @return
     */
    List<SysMenu> findPage();

    /**
     * 查询所有
     * @return
     */
    List<SysMenu> findAll();

    /**
     * 通过用户名称查找
     * @param userName
     * @return
     */
    List<SysMenu> findByUserName(@Param("userName") String userName);

    /**
     * 查询角色菜单
     * @param roleId
     * @return
     */
    List<SysMenu> findRoleMenu(@Param("roleId") Long roleId);
}
