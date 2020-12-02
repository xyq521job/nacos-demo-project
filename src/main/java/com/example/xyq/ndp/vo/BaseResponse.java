/**
 * Tencent is pleased to support the open source community by making Tars available.
 * <p>
 * Copyright (C) 2020 THL A29 Limited, a Tencent company. All rights reserved.
 * <p>
 * Licensed under the BSD 3-Clause License (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * https://opensource.org/licenses/BSD-3-Clause
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.example.xyq.ndp.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * 返回数据类
 */
@ApiModel(value = "通用响应实体")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BaseResponse<T> {

    @ApiModelProperty(value = "状态码", position = 1)
    private Integer code;

    @ApiModelProperty(value = "简述", position = 2)
    private String msg;

    @ApiModelProperty(value = "业务数据", position = 3)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public BaseResponse() {
        this(ResponseCodeEnum.RESPONSE_CODE_SUCCESS);
    }

    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public BaseResponse(ResponseCodeEnum responseCodeEnum) {
        this.code = responseCodeEnum.getProtocolValue();
        this.msg = responseCodeEnum.getProtocolName();
    }

    public BaseResponse(ResponseCodeEnum responseCodeEnum, String msg) {
        this.code = responseCodeEnum.getProtocolValue();
        this.msg = msg;
    }

    public static BaseResponse error() {
        return error(ResponseCodeEnum.RESPONSE_CODE_EXCEPTION);
    }

    public static BaseResponse error(String msg) {
        return error(ResponseCodeEnum.RESPONSE_CODE_EXCEPTION, msg);
    }

    public static BaseResponse error(ResponseCodeEnum responseCodeEnum) {
        return new BaseResponse(responseCodeEnum);
    }

    public static BaseResponse error(ResponseCodeEnum responseCodeEnum, String msg) {
        return new BaseResponse(responseCodeEnum, msg);
    }

    public static BaseResponse ok(String msg) {
        BaseResponse result = new BaseResponse();
        result.setMsg(msg);
        return result;
    }

    public static BaseResponse ok(Map<String, Object> map) {
        BaseResponse result = new BaseResponse();
        result.setData(map);
        return result;
    }

    public static BaseResponse ok() {
        return new BaseResponse();
    }


    public BaseResponse<T> put(T data) {
        this.data = data;
        return this;
    }

    public BaseResponse putMap(String key, Object value) {
        Map map = new HashMap();
        map.put(key, value);
        return put((T) map);
    }

}
