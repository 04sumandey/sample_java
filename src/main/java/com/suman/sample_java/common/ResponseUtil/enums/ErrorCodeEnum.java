package com.suman.sample_java.common.ResponseUtil.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    BadRequest("BAD REQUEST"),
    ResourceNotFound("RESOURCE NOT FOUND"),
    InternalServerError("INTERNAL SERVER ERROR");

    final String Code;
}
