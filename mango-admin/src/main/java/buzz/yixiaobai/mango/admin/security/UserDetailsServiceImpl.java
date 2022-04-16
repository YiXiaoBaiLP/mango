package buzz.yixiaobai.mango.admin.security;

import buzz.yixiaobai.mango.admin.model.SysUser;
import buzz.yixiaobai.mango.admin.server.ISysUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户登录认证信息查询
 * @author yixiaobai
 * @create 2022/04/15 下午5:40
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // 注入UserService接口
    @Resource
    private ISysUserService sysUserService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 获取用户信息
        SysUser user = sysUserService.findByName(s);
        if(user == null){
            throw new UsernameNotFoundException("该用户不存在！");
        }
        // 用户权限表，根据权限标识如@PreAuthorize("hasAuthority('sys:menu:view')")
        // 标注的接口对比，决定是否可以调用接口
        Set<String> permissions = sysUserService.findPermissions(user.getName());
        List<GrantedAuthority> grantedAuthorities = permissions.stream()
                .map(GrantedAuthorityImpl::new).collect(Collectors.toList());
        return new JwtUserDetails(user.getName(), user.getPassword(), user.getSalt(), grantedAuthorities);
    }
}
