package buzz.yixiaobai.mango.backup.controller;

import buzz.yixiaobai.mango.backup.constants.BackupConstants;
import buzz.yixiaobai.mango.backup.datasource.BackupDataSourceProperties;
import buzz.yixiaobai.mango.backup.service.MysqlBackupService;
import buzz.yixiaobai.mango.core.http.HttpResult;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yixiaobai
 * @create 2022/04/20 下午5:36
 */
@RestController
public class MySqlBackupController {

    @Resource
    private MysqlBackupService mysqlBackupService;
    @Resource
    private BackupDataSourceProperties properties;

    /**
     * 备份数据库
     * @return
     */
    @GetMapping("/backup")
    public HttpResult backup() {
        String nowDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern(BackupConstants.DATE_FORMAT));
        String backupFodlerName = BackupConstants.DEFAULT_BACKUP_NAME + "_"
                + nowDate;
        return backup(backupFodlerName);
    }

    private HttpResult backup(String backupFodleName) {
        /** application.xml文件中获取这些属性 */
        String host = properties.getHost();
        String userName = properties.getUserName();
        String password = properties.getPassword();
        String database = properties.getDatabase();
        // 获取备份文件目录
        String backupFolderPath = BackupConstants.BACKUP_FOLDER + backupFodleName + File.separator;
        // 获取备份文件名称
        String fileName= BackupConstants.BACKUP_FILE_NAME;
        try {
            boolean success = mysqlBackupService.backup(host, userName, password,backupFolderPath, fileName, database);
            if(!success){
                HttpResult.error("数据备份失败！");
            }
        } catch(Exception e){
            return HttpResult.error(500, e.getMessage());
        }
        return HttpResult.ok();
    }

    /**
     * 恢复数据库
     * @param name
     * @return
     * @throws IOException
     */
    @GetMapping("/resotre")
    public HttpResult restore(@RequestParam String name) throws IOException {
        String host = properties.getHost();
        String userName = properties.getUserName();
        String password = properties.getPassword();
        String database = properties.getDatabase();
        String restoreFilePath = BackupConstants.RESTORE_FOLDER + name;
        try{
            mysqlBackupService.restore(restoreFilePath, host, userName, password, database);
        } catch(Exception e) {
            return HttpResult.error(500, e.getMessage());
        }
        return HttpResult.ok();
    }

    /**
     * 查找备份并展示
     * @return
     */
    @GetMapping("/findRecords")
    public HttpResult findBackupRecords(){
        // 判断目录是否存在
        if(!new File(BackupConstants.DEFAULT_RESTORE_FILE).exists()){
            // 初始化默认备份文件
            backup(BackupConstants.DEFAULT_BACKUP_NAME);
        }
        List<Map<String, String>> backupRecords = new ArrayList<>();
        File restoreFolderFile = new File(BackupConstants.RESTORE_FOLDER);
        // 判断目录是否存在
        if(restoreFolderFile.exists()){
            for(File file : restoreFolderFile.listFiles()){
                Map<String, String> backup = new HashMap<>();
                backup.put("name", file.getName());
                backup.put("title", file.getName());

                if(BackupConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(file.getName())) {
                    backup.put("title", "系统默认备份");
                }
                backupRecords.add(backup);
            }
        }
        // 排序、默认备份最前，然后按照时间戳排序，新备份在前面
        backupRecords.sort((o1, o2) ->
            BackupConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(o1.get("name")) ? -1 :
                    BackupConstants.DEFAULT_BACKUP_NAME.equalsIgnoreCase(o2.get("name")) ? 1 :
                            o2.get("name").compareTo(o1.get("name")) );
        return HttpResult.ok(backupRecords);
    }

    /**
     * 删除备份接口
     * @param name
     * @return
     */
    @GetMapping("/delete")
    public HttpResult deleteBackupRecord(@RequestParam String name) {
        if(BackupConstants.DEFAULT_BACKUP_NAME.equals(name)){
            return HttpResult.error("系统默认备份无法删除！");
        }
        // 获取备份文件的目录
        String restoreFilePath = BackupConstants.BACKUP_FOLDER + name;
        try{
            // 删除备份文件
            FileUtils.deleteDirectory(new File(restoreFilePath));
        } catch(Exception e) {
            return HttpResult.error(500, e.getMessage());
        }
        return HttpResult.ok();
    }
}
