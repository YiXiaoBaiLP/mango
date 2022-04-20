package buzz.yixiaobai.mango.backup.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置
 * @author yixiaobai
 * @create 2022/04/20 下午3:32
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    // 重写父类的方法
    @Override
    public void addCorsMappings(CorsRegistry registry){
        // 允许跨域访问的路径
        registry.addMapping("/**")
                // 允许跨域访问的源
                .allowedOrigins("*")
                // 允许请求的方法
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                // 预检间隔时间
                .maxAge(168000)
                // 允许头部设置
                .allowedHeaders("*")
                // 是否发送cookie
                .allowCredentials(true);
    }
}
