package buzz.yixiaobai.mango.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yixiaobai
 * @create 2022/05/01 上午1:33
 */
@EnableAdminServer // 开启监控服务
@SpringBootApplication
public class MangoMonitor {
    public static void main(String[] args){
        SpringApplication.run(MangoMonitor.class, args);
    }
}
