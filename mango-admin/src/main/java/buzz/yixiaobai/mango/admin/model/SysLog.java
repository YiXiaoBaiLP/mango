package buzz.yixiaobai.mango.admin.model;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 系统操作日志表
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "SysLog对象", description = "系统操作日志表")
public class SysLog {

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户操作")
    private String operation;

    @ApiModelProperty("请求方法")
    private String method;

    @ApiModelProperty("请求参数")
    private String params;

    @ApiModelProperty("执行时长（毫秒）")
    private Long time;

    @ApiModelProperty("IP地址")
    private String ip;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新人")
    private String lastUpdateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime lastUpdateTime;
}
