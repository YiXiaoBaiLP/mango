package buzz.yixiaobai.mango.core.http;

import lombok.Data;

/**
 * HTTP结果封装
 * @author yixiaobai
 * @create 2022/03/21 上午11:55
 */
@Data
public class HttpResult {

    private Integer code = 200;
    private String message;
    private Object data;

    public static HttpResult error(){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static HttpResult error(String message){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, message);
    }

    public static HttpResult error(int code, String message){
        HttpResult r = new HttpResult();
        r.setCode(code);
        r.setMessage(message);

        return r;
    }

    public static HttpResult ok(String mesage){
        HttpResult r = new HttpResult();
        r.setMessage(mesage);
        return r;
    }

    public static HttpResult ok(Object data){
        HttpResult r = new HttpResult();
        r.setData(data);

        return r;
    }

    public static HttpResult ok(){
        return new HttpResult();
    }
}
