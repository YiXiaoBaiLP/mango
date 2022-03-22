package buzz.yixiaobai.common.utils;

/**
 * 字符串工具类
 * @author yixiaobai
 * @create 2022/03/21 下午3:41
 */
public class StringUtils {

    /**
     * 字符串判空
     * @param value
     * @return
     */
    public static boolean isBlank(String value){
        return value == null || "".equals(value) || "null".equals(value) || "undefined".equals(value);
    }
}
