package buzz.yixiaobai.mango.backup.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置类
 * @author yixiaobai
 * @create 2022/04/20 下午3:39
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket crateRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                // 所有请求
                .apis(RequestHandlerSelectors.any())
                // 所有路径
                .paths(PathSelectors.any())
                .build();
    }
}
