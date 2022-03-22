package buzz.yixiaobai.mango.admin.dao;


import buzz.yixiaobai.mango.admin.model.SysMenu;

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
}
