package buzz.yixiaobai.mango.backup.service;

/**
 * 备份还原接口
 * @author yixiaobai
 * @create 2022/04/20 下午3:52
 */
public interface MysqlBackupService {
    /**
     * 备份数据库
     * @param host 地址
     * @param userName 数据库的用户名
     * @param password 数据库的密码
     * @param backupFolderPath 备份文件路径
     * @param fileName 备份文件名称
     * @param database 需要备份的数据库名称
     * @return 是否成功
     * @throws Exception 出现异常时抛出
     */
    boolean backup(String host, String userName, String password,
                   String backupFolderPath, String fileName, String database) throws Exception;

    /**
     * 恢复数据库
     * @param restoreFilePath 数据库备份的脚本路径
     * @param host 地址
     * @param userName 用户名
     * @param password 密码
     * @param database 需要恢复的数据库
     * @return 是否成功
     * @throws Exception 出现异常抛出
     */
    boolean restore(String restoreFilePath, String host, String userName, String password,
                    String database) throws Exception;
}
