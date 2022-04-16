package buzz.yixiaobai.mango.admin.vo;

import lombok.Data;

/**
 * 登录接口封装对象
 * @author yixiaobai
 * @create 2022/04/16 下午4:46
 */
@Data
public class LoginBean {
    private String account;
    private String password;
    private String captcha;
}
