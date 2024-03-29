package buzz.yixiaobai.mango.admin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 明文密码加密
 * @author yixiaobai
 * @create 2022/04/08 下午3:52
 */
public class PasswordEncoder {

    // 十六进制数字
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", };
    // MD5 加密
    private final static String MD5 = "MD5";
    // SHA 加密
    private final static String SHA = "SHA";
    // 加密盐
    private Object salt;
    private String algorithm;

    public PasswordEncoder(Object salt) {
        this(salt, MD5);
    }

    public PasswordEncoder(Object salt, String algorithm) {
        this.salt = salt;
        this.algorithm = algorithm;
    }

    /**
     * 密码加密
     * @param rawPass 明文
     * @return 密文
     */
    public String encode(String rawPass) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            // 获取加密后的字符串
            result = byteArrayToHexString(md.digest(mergePasswordAndSalt(rawPass).getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 密码匹配验证
     * @param encPass 密文
     * @param rawPass 明文
     * @return
     */
    public boolean matches(String encPass, String rawPass) {
        String pass1 = "" + encPass;
        String pass2 = encode(rawPass);
        return pass1.equals(pass2);
    }

    private String mergePasswordAndSalt(String password) {
        if(password == null){
            password = "";
        }
        if(salt == null || "".equals(salt)){
            return password;
        } else {
            return password + "{" + salt + "}";
        }
    }

    /**
     * 转换字节数组为16进制字符串
     * @param b 字节数组
     * @return  16进制字符串
     */
    private String byteArrayToHexString(byte[] b) {
        StringBuffer resultsb = new StringBuffer();
        for (byte value : b) {
            resultsb.append(byteToHexString(value));
        }
        return resultsb.toString();
    }

    /**
     * 将字符转为16进制
     * @param b
     * @return
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if(n < 0){
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static void main(String[] args) {
        String salt = "helloworld";
        PasswordEncoder encoderMD5 = new PasswordEncoder(salt);
        String encodeMD5 = encoderMD5.encode("1qazXSW@");
        System.out.println(encodeMD5);
        boolean passwordValid = encoderMD5.matches("88463c84ddd8100f11f7d687ca4cc929", "1qazXSW@");
        System.out.println("MD5加密前与加密后一致吗？：" + passwordValid);
        System.out.println("---------------------------------------------------------------------------------");
        PasswordEncoder encoderSHA = new PasswordEncoder(salt, PasswordEncoder.SHA);
        String encodeSHA = encoderSHA.encode("test");
        System.out.println(encodeSHA);
        boolean passwordValidSHA = encoderSHA.matches("1e4346dcb54c1444e91668e04b8ca4f74f42958e", "test");
        System.out.println("SHA加密前与加密后一致吗？：" + passwordValidSHA);
    }
}
