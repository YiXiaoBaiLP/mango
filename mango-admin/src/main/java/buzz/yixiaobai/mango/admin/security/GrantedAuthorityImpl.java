package buzz.yixiaobai.mango.admin.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * 权限封装
 *      GrantedAuthorityImpl实现Spring Security的GrantedAuthority接口，是对权限的封装，内部包含
 *      一个字符串类型的权限标志authority，对应菜单表中的perms字段的权限字符串，比如用户管理的增、删、改、查权限标志
 *      sys:user:view、sys:user:add、sys:user:edit、sys:user:delete
 *
 * @author yixiaobai
 * @create 2022/04/15 下午6:00
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority){
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
