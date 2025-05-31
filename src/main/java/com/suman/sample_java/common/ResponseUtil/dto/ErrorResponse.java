package com.suman.sample_java.common.ResponseUtil.dto;

import java.util.Map;

import jakarta.persistence.MappedSuperclass;
import lombok.Builder;
import lombok.Data;

@MappedSuperclass
@Data
@Builder
public class ErrorResponse {
    String errorCode;
    String errorMessage;
    Map<String, String> details;
}
