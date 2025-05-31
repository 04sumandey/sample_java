package com.suman.sample_java.common.ResponseUtil.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCodeEnum {
    ok(200),
    bad_request(400),
    not_found(404),
    internal_server_error(500);
    final int code;
}
