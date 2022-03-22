package buzz.yixiaobai.common.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * IO相关工具类
 * @author yixiaobai
 * @create 2022/03/21 下午7:35
 */
public class IOUtils {

    public static void closeQuietly(final Closeable closeable){
        try {
            if (closeable != null) {
                 closeable.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
