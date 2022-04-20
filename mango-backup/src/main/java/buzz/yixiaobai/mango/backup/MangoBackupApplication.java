package buzz.yixiaobai.mango.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * 主启动类
 * @author yixiaobai
 * @create 2022/04/20 下午3:27
 */
// 指定包扫描路径
@SpringBootApplication(scanBasePackages={"buzz.yixiaobai.mango"},exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class MangoBackupApplication {
    public static void main(String[] args){
        SpringApplication.run(MangoBackupApplication.class, args);
    }
}
