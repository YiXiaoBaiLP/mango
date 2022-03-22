package buzz.yixiaobai.mango.admin.dao;


import buzz.yixiaobai.mango.admin.model.SysRoleDept;

/**
 * <p>
 * 角色机构 Mapper 接口
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface SysRoleDeptMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysRoleDept sysRoleDept);

    int insertSelective(SysRoleDept sysRoleDept);

    SysRoleDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleDept sysRoleDept);

    int updateByPrimaryKey(SysRoleDept sysRoleDept);

}
