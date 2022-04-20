package buzz.yixiaobai.mango.backup.utils;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

/**
 * MySQL备份还原工具类
 * @author yixiaobai
 * @create 2022/04/20 下午4:11
 */
public class MysqlBackupRestoreUtils {

    /**
     * 备份数据库
     * @param host 地址
     * @param userName 用户名称
     * @param password 用户密码
     * @param backupFolderPath 备份的路径
     * @param fileName 备份文件名
     * @param database 备份的数据库
     * @return 是否成功
     * @throws Exception 抛出异常
     */
     public static boolean backup(String host, String userName, String password, String backupFolderPath, String fileName,
                                  String database) throws Exception {
         // 通过备份路径获取文件
         File backupFolderFile = new File(backupFolderPath);
         // 判断文件或文件夹是否存在
         if(!backupFolderFile.exists()){
            // 如果目录不存在，则创建（递归创建）
             backupFolderFile.mkdirs();
         }
         // 判断目录结尾是否为“/”
        if(!backupFolderPath.endsWith(File.separator)
        && !backupFolderPath.endsWith("/")){
            // 目录末尾添加“/”
            backupFolderPath = backupFolderPath + File.separator;
        }
        String backupFilePath = backupFolderPath + fileName;
        // 拼接命令行命令
         StringBuilder sb = new StringBuilder();
         sb.append("mysqldump --opt")
                 .append(" --add-drop-database ")
                 .append(" --ad-drop-table ");
         sb.append(" -h ")
                 .append(host)
                 .append(" -u ")
                 .append(userName)
                 .append(" -p ")
                 .append(password);
         sb.append(" --result-file=")
                 .append(backupFilePath)
                 .append(" --default-character-set=utf8 ")
                 .append(database);
         // 调用外部执行exe文件Java API
         Process process = Runtime.getRuntime().exec(getCommand(sb.toString()));
         // 判断是否执行成功
         if(process.waitFor() == 0){
            // 0表示线程正常终止
             System.out.println("数据已经备份到 " + backupFilePath + " 文件中。");
             return true;
         }
         return false;
     }

    /**
     * 恢复数据库
     * @param restoreFilePath 脚本文件
     * @param host 地址
     * @param userName 用户名
     * @param password 用户密码
     * @param database 还原的数据库
     * @return 是否成功
     * @throws Exception 抛出异常
     */
     public static boolean restore(String restoreFilePath, String host, String userName, String password,String database) throws Exception{
         // 获得文件目录对象
        File restoreFile = new File(restoreFilePath);
        // 是否是一个目录
         if (restoreFile.isDirectory()) {
             for(File file : restoreFile.listFiles()){
                 if (file.exists() && file.getPath().endsWith(".sql")) {
                     // 获取到文件的绝对路径
                     restoreFilePath = file.getAbsolutePath();
                     break;
                 }
             }
         }
         // 构建导入脚本的命令
         StringBuilder sb = new StringBuilder();
         sb.append("mysql -h ")
                .append(host)
                .append("-u ")
                .append(userName)
                .append(" -p ")
                .append(password);
         sb.append(" ")
                 .append(database)
                 .append(" < ")
                 .append(restoreFilePath);

         try{
             // 执行命令
             Process process = Runtime.getRuntime().exec(getCommand(sb.toString()));
             if(process.waitFor() == 0){
                 System.out.println("数据已从 " + restoreFilePath + " 导入到数据库中。");
             }
         } catch(IOException e){
             e.printStackTrace();
             return false;
         }
         return true;
     }

    /**
     * 使用指定的shell执行
     * @param command 执行的命令
     * @return 指定的shell执行命令
     */
     private static String[] getCommand(String command){
         // 获取系统名称
        String os = System.getProperty("os.name");
        String shell = "/bin/bash";
        String c = "-c";
        if(os.toLowerCase().endsWith("win")){
            shell = "cmd";
            c = "/c";
        }
        String[] cmd = {shell, c, command};
        return cmd;
     }
}
