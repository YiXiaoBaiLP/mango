package buzz.yixiaobai.mango.core.exception;

import lombok.Data;

/**
 * 自定义异常
 * @author yixiaobai
 * @create 2022/03/21 上午10:54
 */
@Data
public class MangoException extends RuntimeException{

    private String message;

    private Integer  code  = 500;

    public MangoException(String message){
        super(message);
        this.message = message;
    }

    public MangoException(String message, Exception e){
        super(message, e);
        this.message = message;
    }

    public MangoException(String message, int code, Exception e){
        super(message, e);
        this.message = message;
        this.code = code;
    }
}
