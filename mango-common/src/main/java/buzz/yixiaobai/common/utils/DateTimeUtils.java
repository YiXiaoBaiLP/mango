package buzz.yixiaobai.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间相关工具类
 * @author yixiaobai
 * @create 2022/03/21 下午3:44
 */
public class DateTimeUtils {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前格式化日期时间
     * @return
     */
    public static String getDateTime(){
        return getDateTime(new Date());
    }

    /**
     * 标准格式化日期时间
     * @param date
     * @return
     */
    public static String getDateTime(Date date){
        return (new SimpleDateFormat(DATE_FORMAT)).format(date);
    }
}
