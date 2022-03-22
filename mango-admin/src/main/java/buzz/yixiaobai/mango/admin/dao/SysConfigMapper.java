package buzz.yixiaobai.mango.admin.dao;


import buzz.yixiaobai.mango.admin.model.SysConfig;

/**
 * <p>
 * 系统配置表 Mapper 接口
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
public interface SysConfigMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysConfig sysConfig);

    int insertSelective(SysConfig sysConfig);

    SysConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysConfig sysConfig);

    int updateByPrimaryKey(SysConfig sysConfig);

}
