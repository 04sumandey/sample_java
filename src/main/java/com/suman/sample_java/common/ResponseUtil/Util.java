package com.suman.sample_java.common.ResponseUtil;

import com.suman.sample_java.common.ResponseUtil.enums.StatusCodeEnum;
import com.suman.sample_java.common.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import com.suman.sample_java.common.ResponseUtil.dto.ErrorResponse;
import com.suman.sample_java.common.ResponseUtil.dto.Response;
import com.suman.sample_java.common.ResponseUtil.enums.ErrorCodeEnum;
import com.suman.sample_java.common.exceptions.BadRequestException;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class Util {
    public <T> Response<T> SuccessBuilder(T data) {
        return Response.<T>builder().status(200).data(data).build();
    }

    public <T> Response<T> FailureBuilder(Exception e) {
        int status;
        ErrorResponse errorResponse;

        if (e instanceof NullPointerException) {
            status = StatusCodeEnum.internal_server_error.getCode();
            errorResponse = ErrorResponse.builder().errorCode(ErrorCodeEnum.InternalServerError.getCode())
                    .errorMessage("Null pointer encountered.").build();
        } else if (e instanceof IllegalArgumentException) {
            status = StatusCodeEnum.bad_request.getCode();
            errorResponse = ErrorResponse.builder().errorCode(ErrorCodeEnum.BadRequest.getCode())
                    .errorMessage("Invalid argument.").build();
        } else if (e instanceof ResourceNotFoundException) {
            status = StatusCodeEnum.not_found.getCode();
            errorResponse = ErrorResponse.builder().errorCode(ErrorCodeEnum.ResourceNotFound.getCode())
                    .errorMessage(e.getMessage()).build();
        } else if (e instanceof BadRequestException bre) {
            status = StatusCodeEnum.not_found.getCode();
            errorResponse = ErrorResponse.builder().errorCode(ErrorCodeEnum.BadRequest.getCode())
                    .errorMessage("Bad request").details(bre.getDetails()).build();
        } else {
            status = StatusCodeEnum.internal_server_error.getCode();
            errorResponse = ErrorResponse.builder().errorCode(ErrorCodeEnum.InternalServerError.getCode())
                    .errorMessage(e.getMessage()).build();
        }

        return Response.<T>builder().status(status).data(null).error(errorResponse).build();
    }
}
