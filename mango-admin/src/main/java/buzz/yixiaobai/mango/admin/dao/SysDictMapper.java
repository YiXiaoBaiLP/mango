package buzz.yixiaobai.mango.admin.dao;


import buzz.yixiaobai.mango.admin.model.SysDict;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface SysDictMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysDict sysDict);

    int insertSelective(SysDict sysDict);

    SysDict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDict sysDict);

    int updateByPrimaryKey(SysDict sysDict);

}
