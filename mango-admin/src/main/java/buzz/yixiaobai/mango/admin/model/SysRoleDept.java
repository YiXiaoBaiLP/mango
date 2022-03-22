package buzz.yixiaobai.mango.admin.model;

import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 角色机构
 * </p>
 *
 * @author yixiaobai
 * @since 2022-03-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "SysRoleDept对象", description = "角色机构")
public class SysRoleDept {

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("角色ID")
    private Long roleId;

    @ApiModelProperty("机构ID")
    private Long deptId;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新人")
    private String lastUpdateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime lastUpdateTime;

}
