package buzz.yixiaobai.mango.admin.model;

import java.time.LocalDateTime;
import java.util.List;

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
@ApiModel(value = "SysMenu对象", description = "机构管理")
public class SysMenu {

    @ApiModelProperty("编号")
    private Long id;

    @ApiModelProperty("菜单名称")
    private String name;

    @ApiModelProperty("父菜单ID，一级菜单为0")
    private Long parentId;

    @ApiModelProperty("菜单URL，类型：1、普通页面（如用户管理，/sys/user）2、嵌套完整外部画面，以http(s)开头的链接 3、嵌套服务器页面，使用iframe：前缀+目标URL（如SQL监控，iframe:/druid/login.html, iframe:前缀会替换成服务器地址）")
    private String url;

    @ApiModelProperty("授权（多个用逗号分隔，如：sys:user:add,sys:user:edit）")
    private String perms;

    @ApiModelProperty("类型 0：目录	1：菜单	2:按钮")
    private Integer type;

    @ApiModelProperty("菜单图标")
    private String icon;

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

    private String parentName;

    private Integer level;

    private List<SysMenu> children;
}
