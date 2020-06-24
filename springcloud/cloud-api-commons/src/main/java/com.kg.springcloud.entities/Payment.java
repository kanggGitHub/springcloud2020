package com.kg.springcloud.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @auther zzyy
 * @create 2020-02-18 17:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "测试实体类", description = "测试实体类,可以有很长的一段描述信息")
public class Payment implements Serializable
{
    private Long id;
    @ApiModelProperty(value = "内容", required = true)
    private String serial;
}
