package buzz.yixiaobai.mango.admin.dao;


import buzz.yixiaobai.mango.admin.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户管理 Mapper 接口
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface SysUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);
    
    int updateByPrimaryKey(SysUser record);

    /**
     * 分页查询
     * @return
     */
    List<SysUser> findPage();

    SysUser findByName(@Param("name") String name);

    List<SysUser> findPageByName(@Param("name") String name);

    List<SysUser> findPageByNameAndEmail(@Param("name") String name, @Param("email") String email);

}
