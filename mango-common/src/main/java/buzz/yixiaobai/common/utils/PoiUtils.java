package buzz.yixiaobai.common.utils;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;

/**
 * 生成Excel文件
 * @author yixiaobai
 * @create 2022/03/21 下午7:37
 */
public class PoiUtils {

    /**
     * 生成Excel文件
     * @param workbook
     * @param fileName
     * @return
     */
    public static File crateExcelFile(Workbook workbook, String fileName){
        OutputStream stream = null;
        File file = null;

        try {
            // 创建一个临时文件
            file = File.createTempFile(fileName, ".xlsx");
            stream = new FileOutputStream(file.getAbsoluteFile());
            workbook.write(stream);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            IOUtils.closeQuietly(workbook);
            IOUtils.closeQuietly(stream);
        }
        return file;
    }
}
