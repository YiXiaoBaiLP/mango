package buzz.yixiaobai.mango.admin.model;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 机构管理
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "SysDept对象", description = "机构管理")
public class SysDept {

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("机构名称")
    private String name;

    @ApiModelProperty("上级机构ID，一级机构为0")
    private Long parentId;

    @ApiModelProperty("排序")
    private Integer orderNum;

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
