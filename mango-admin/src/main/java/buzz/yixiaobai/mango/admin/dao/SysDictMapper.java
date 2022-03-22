package buzz.yixiaobai.mango.admin.dao;


import buzz.yixiaobai.mango.admin.model.SysDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 分页查询
     */
    List<SysDict> findPage();

    /**
     * 根据标签名称
     * @param label
     * @return
     */
    List<SysDict> findByLabel(@Param("label") String label);

    /**
     * 根据标签名称分页查询
     * @param label
     * @return
     */
    List<SysDict> findPageByLabel(@Param("label") String label);
}
