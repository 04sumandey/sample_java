package com.suman.sample_java.common.ResponseUtil.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class Response<T> {
    int status;
    T data;
    ErrorResponse error;

    public ResponseEntity<Response<T>> toEntity() {
        return ResponseEntity.status(this.status).body(this);
    }
}
