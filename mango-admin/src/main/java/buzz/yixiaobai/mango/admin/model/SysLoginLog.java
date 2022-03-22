package buzz.yixiaobai.mango.admin.model;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 系统登录日志
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "SysLoginLog对象", description = "系统登录日志")
public class SysLoginLog {

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("登录状态（online：在线，登录初始状态，方便统计在线人数；login：退出登录后将online置为login；logout：退出登录）")
    private String status;

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
