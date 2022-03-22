package buzz.yixiaobai.mango.core.page;

import lombok.Data;

import java.util.List;

/**
 * 分页结果的统一封装
 * @author yixiaobai
 * @create 2022/03/21 上午11:17
 */
@Data
public class PageResult {

    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 每页数量
     */
    private Integer pageSize;

    /**
     * 记录总数
     */
    private Long totalSize;

    /**
     * 页码总数
     */
    private Integer totalPages;

    /**
     * 分页数量
     */
    private List<?> content;
}
