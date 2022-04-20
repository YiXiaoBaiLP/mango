package buzz.yixiaobai.mango.backup.service.impl;

import buzz.yixiaobai.mango.backup.service.MysqlBackupService;
import buzz.yixiaobai.mango.backup.utils.MysqlBackupRestoreUtils;
import org.springframework.stereotype.Service;

/**
 * 备份还原实现
 * @author yixiaobai
 * @create 2022/04/20 下午4:03
 */
@Service
public class MysqlBackupServiceImpl implements MysqlBackupService {

    /**
     * 备份数据库
     * @param host 地址
     * @param userName 数据库的用户名
     * @param password 数据库的密码
     * @param backupFolderPath 备份文件路径
     * @param fileName 备份文件名称
     * @param database 需要备份的数据库名称
     * @return
     * @throws Exception
     */
    @Override
    public boolean backup(String host, String userName, String password, String backupFolderPath, String fileName, String database) throws Exception {
        return MysqlBackupRestoreUtils.backup(host, userName, password, backupFolderPath, fileName, database);
    }

    /**
     * 恢复数据库
     * @param restoreFilePath 数据库备份的脚本路径
     * @param host 地址
     * @param userName 用户名
     * @param password 密码
     * @param database 需要恢复的数据库
     * @return
     * @throws Exception
     */
    @Override
    public boolean restore(String restoreFilePath, String host, String userName, String password, String database) throws Exception {
        return MysqlBackupRestoreUtils.restore(restoreFilePath, host, userName, password, database);
    }
}
