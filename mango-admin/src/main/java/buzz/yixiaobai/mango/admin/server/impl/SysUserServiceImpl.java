package buzz.yixiaobai.mango.admin.server.impl;

import buzz.yixiaobai.mango.admin.dao.SysUserMapper;
import buzz.yixiaobai.mango.admin.model.SysUser;
import buzz.yixiaobai.mango.admin.server.ISysUserService;
import buzz.yixiaobai.mango.core.page.MyBatisPageHelper;
import buzz.yixiaobai.mango.core.page.PageRequest;
import buzz.yixiaobai.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户管理 服务实现类
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@Service
public class SysUserServiceImpl implements ISysUserService{

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }

    @Override
    public int save(SysUser record) {
        return 0;
    }

    @Override
    public int delete(SysUser record) {
        return 0;
    }

    @Override
    public int delete(List<SysUser> records) {
        return 0;
    }

    @Override
    public SysUser findById(Long id) {
        return null;
    }

    /**
     * 分页查询
     * @param pageRequest 自定义：统一分页查询请求
     * @return
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MyBatisPageHelper.findPage(pageRequest, sysUserMapper);
    }
}
