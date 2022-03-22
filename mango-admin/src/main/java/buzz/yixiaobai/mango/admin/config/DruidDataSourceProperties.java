package buzz.yixiaobai.mango.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 数据源配置
 * @author yixiaobai
 * @create 2022/03/20 下午4:53
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidDataSourceProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String filters;
    private Integer initialSize;
    private Integer minIdle;
    private Integer maxActive = 100;
    private Long maxWait;
    private Long timeBetweenEvictionRunsMillis;
    private Long minEvictableIdleTimeMillis;
    private String validationQuery;
    private Boolean testWhileIdle;
    private Boolean testOnBorrow;
    private Boolean testOnReturn;
    private Boolean poolPreparedStatements;
    private Integer maxPoolPreparedStatementPerConnectionSize;


}
