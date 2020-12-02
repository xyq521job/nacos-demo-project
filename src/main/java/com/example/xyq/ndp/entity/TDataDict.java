package com.example.xyq.ndp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

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
@AllArgsConstructor
@NoArgsConstructor
//indexName代表索引名称,type代表表名称
@Document(indexName = "data_dict_info")
public class TDataDict{

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键ID")
    @Id
    private Long id;

    @ApiModelProperty(value = "字典Code")
    @JsonProperty("code")
    private Integer code;

    @ApiModelProperty(value = "字典名称")
    @JsonProperty("code_name")
    private String codeName;

    @ApiModelProperty(value = "字典类型")
    @JsonProperty("code_type")
    private Integer codeType;

    @ApiModelProperty(value = "字典备注")
    @JsonProperty("remark")
    private String remark;

    @ApiModelProperty(value = "字典扩展字段")
    @JsonProperty("code_ext")
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
