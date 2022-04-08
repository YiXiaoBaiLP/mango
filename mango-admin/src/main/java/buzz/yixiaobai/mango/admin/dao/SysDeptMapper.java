package buzz.yixiaobai.mango.admin.dao;

import buzz.yixiaobai.mango.admin.model.SysDept;
import buzz.yixiaobai.mango.core.page.PageRequest;

import java.util.List;

/**
 * <p>
 * 机构管理 Mapper 接口
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface SysDeptMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysDept sysDept);

    int insertSelective(SysDept sysDept);

    SysDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDept sysDept);

    int updateByPrimaryKey(SysDept sysDept);

    List<SysDept> findPage();

    List<SysDept> findAll();
}
