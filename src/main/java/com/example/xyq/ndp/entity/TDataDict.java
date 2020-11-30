package com.example.xyq.ndp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 数据字典表
 * </p>
 *
 * @author xingyinqiang
 * @since 2020-11-26
 */
@Data
@EqualsAndHashCode()
@ApiModel(value="TDataDict对象", description="数据字典表")
public class TDataDict{

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "字典Code")
    private Integer code;

    @ApiModelProperty(value = "字典名称")
    private String codeName;

    @ApiModelProperty(value = "字典类型")
    private Integer codeType;

    @ApiModelProperty(value = "字典备注")
    private String remark;

    @ApiModelProperty(value = "字典扩展字段")
    private String codeExt;

    @ApiModelProperty(value = "状态:0:未启用 1:启用 2:禁用 -1:已删除")
    private Integer status;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新人")
    private String updater;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}
