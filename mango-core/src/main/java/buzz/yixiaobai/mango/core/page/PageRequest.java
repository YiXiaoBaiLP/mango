package buzz.yixiaobai.mango.core.page;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 对分页请求的统一封装
 * @author yixiaobai
 * @create 2022/03/21 上午11:14
 */
@Data
public class PageRequest {

    /**
     * 当前页码
     */
    private Integer pageNum = 1;

    /**
     * 每页数量
     */
    private Integer pageSize = 10;

    /**
     * 查询参数
     */
    private Map<String, Object> params = new HashMap<>();

    public Object getParam(String key){
        return params.get(key);
    }
}
