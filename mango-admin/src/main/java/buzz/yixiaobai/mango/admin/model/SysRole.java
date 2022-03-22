package buzz.yixiaobai.mango.admin.model;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 角色管理
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "SysRole对象", description = "角色管理")
public class SysRole {

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新人")
    private String lastUpdateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime lastUpdateTime;

    @ApiModelProperty("是否删除 -1：已删除	0：正常")
    private Integer delFlag;

}
