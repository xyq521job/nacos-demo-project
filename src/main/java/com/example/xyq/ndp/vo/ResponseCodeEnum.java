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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;

/**
 * 返回信息
 */
public enum ResponseCodeEnum {
    // 业务行为
    RESPONSE_CODE_SUCCESS("success", 0),
    RESPONSE_CODE_EXCEPTION("unexcepted exception", -10099),
    RESPONSE_CODE_ERROR("error", -10098),

    RESPONSE_CODE_INVALID_PARAMETER("invalid parameter", -10001),
    RESPONSE_CODE_INVALID_PERMISSION("invalid permission", -10002),
    RESPONSE_CODE_NOT_SUPPORT("not support", -10003),
    RESPONSE_INSERT_DATA_ALREADY_EXISTS("insert data already exists in database", -10004),

    RESPONSE_CODE_BUTT("RESPONSE_CODE_BUTT", 29999),
    ;

    private static HashMap<Integer, ResponseCodeEnum> map = new HashMap<Integer, ResponseCodeEnum>();

    static {
        for (ResponseCodeEnum responseCodeEnum : ResponseCodeEnum.values()) {
            map.put(responseCodeEnum.getProtocolValue(), responseCodeEnum);
        }
    }

    private String protocolName;
    private int protocolValue;
    private Integer rawValue;

    ResponseCodeEnum(String protocolName, int protocolValue) {
        this.protocolName = protocolName;
        this.protocolValue = protocolValue;
    }

    @JsonCreator
    public static ResponseCodeEnum fromValue(Integer protocolValue) {
        if (null == protocolValue) {
            return RESPONSE_CODE_BUTT;
        }

        ResponseCodeEnum codeEnum = map.getOrDefault(protocolValue, RESPONSE_CODE_BUTT);
        codeEnum.setRawValue(protocolValue);
        return codeEnum;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public int getProtocolValue() {
        return protocolValue;
    }

    public void setRawValue(Integer rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public String toString() {
        return protocolName + " (" + protocolValue + ")";
    }

    @JsonValue
    public Integer toValue() {
        if (null != rawValue) {
            return rawValue;
        }
        return protocolValue;
    }
}
