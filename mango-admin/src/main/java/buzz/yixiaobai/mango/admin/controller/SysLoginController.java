package buzz.yixiaobai.mango.admin.controller;

import buzz.yixiaobai.common.utils.IOUtils;
import buzz.yixiaobai.mango.admin.model.SysUser;
import buzz.yixiaobai.mango.admin.security.JwtAuthenticationToken;
import buzz.yixiaobai.mango.admin.server.ISysUserService;
import buzz.yixiaobai.mango.admin.util.PasswordUtils;
import buzz.yixiaobai.mango.admin.util.SecurityUtils;
import buzz.yixiaobai.mango.admin.vo.LoginBean;
import buzz.yixiaobai.mango.core.http.HttpResult;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登录控制器
 * @author yixiaobai
 * @create 2022/04/14 下午9:40
 */
@RestController
public class SysLoginController {

    @Resource
    private Producer producer;
    @Resource
    private ISysUserService sysUserService;
    @Resource
    private AuthenticationManager authenticationManager;

    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存验证码到session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        // 关闭流
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录接口
     * @param LoginBean
     * @param request
     * @return
     */
    @PostMapping("/login")
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) {
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        // 从session中获取之前保存的验证码，跟前台传来的验证码进行匹配
        Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(kaptcha == null){
            return HttpResult.error("验证码已失效");
        }
        // 判断验证码是否正确
        if(!captcha.equals(kaptcha)){
            return HttpResult.error("验证码不正确");
        }

        // 用户信息
        SysUser user = sysUserService.findByName(username);
        // 帐号不存在
        if(user == null){
            return HttpResult.error("帐号不存在");
        }
        // 密码错误
        if(!PasswordUtils.matches(user.getSalt(), password, user.getPassword())){
            return HttpResult.error("密码错误");
        }
        // 帐号锁定
        if(user.getStatus() == 0){
            return HttpResult.error("帐号已被锁定，请联系管理员");
        }
        // 系统登录认证
        //      1、将用户名密码的认证信息封装到JwtAuthenticationToken对象
        //      2、通过调用啊uthenticationManager.authenticate(token)执行认证流程
        //      3、通过SecurityContextHander将认证信息保存到Security上下文
        //      4、通过JwtTokenUtils.generateToken(authentication)生成token并返回
        JwtAuthenticationToken token = SecurityUtils.login(request, username, password, authenticationManager);
        // 登录成功
        return HttpResult.ok(token);
    }
}
