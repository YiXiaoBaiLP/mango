package buzz.yixiaobai.mango.backup.datasource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yixiaobai
 * @create 2022/04/20 下午3:47
 */
@Component

@Data
@ConfigurationProperties(prefix="mango.backup.datasource") // 使用此注解就可以读取application.xml文件中指定的属性了
public class BackupDataSourceProperties {

    private String host;
    private String userName;
    private String password;
    private String database;
}
