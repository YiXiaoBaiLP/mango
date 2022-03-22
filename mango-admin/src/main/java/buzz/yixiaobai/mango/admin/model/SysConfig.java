package buzz.yixiaobai.mango.admin.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 系统配置表
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "SysConfig对象", description = "系统配置表")
public class SysConfig{

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("数据值")
    private String value;

    @ApiModelProperty("标签名")
    private String label;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("排序（升序）")
    private BigDecimal sort;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新人")
    private String lastUpdateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime lastUpdateTime;

    @ApiModelProperty("备注信息")
    private String remarks;

    @ApiModelProperty("是否删除 -1：已删除	0：正常")
    private Integer delFlag;

}
