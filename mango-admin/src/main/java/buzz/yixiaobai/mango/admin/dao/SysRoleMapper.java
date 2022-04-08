package buzz.yixiaobai.mango.admin.dao;


import buzz.yixiaobai.mango.admin.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色管理 Mapper 接口
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface SysRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysRole sysRole);

    int insertSelective(SysRole sysRole);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole sysRole);

    int updateByPrimaryKey(SysRole sysRole);

    /**
     * 分页查询
     * @return
     */
    List<SysRole> findPage();

    /**
     * 查询所有
     * @return
     */
    List<SysRole> findAll();

    List<SysRole> findPageByName(@Param("name") String name);

    List<SysRole> findByName(@Param("name") String name);

}
