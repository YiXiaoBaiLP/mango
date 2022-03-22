package buzz.yixiaobai.common.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件相关操作
 * @author yixiaobai
 * @create 2022/03/21 下午4:02
 */
public class FileUtils {

    /**
     * 下载文件
     * @param response
     * @param file
     * @param newFileName
     */
    public static void download(HttpServletResponse response, File file, String newFileName){
        try {
            response.setHeader("Content-Disposition", "attachment; filename=" +
                    new String(newFileName.getBytes("ISO-8859-1"),"UTF-8"));
            // 获取输出流
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            // 获取输入流（取得文件输出的绝对路径）
            InputStream is = new FileInputStream(file.getAbsoluteFile());
            BufferedInputStream bis =  new BufferedInputStream(is);
            int length = 0;
            byte[] temps = new byte[10240];
            while ((length =  bis.read(temps)) != -1){
                bos.write(temps, 0, length);
            }
            bos.flush();
            // 关闭所有的流，先打开的后关闭
            bis.close();
            bos.close();
            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
