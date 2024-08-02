package org.cybersoft.capstone.mapper;

import org.cybersoft.capstone.constant.Status;
import org.cybersoft.capstone.payload.response.BaseResponse;

public class ResponseMapper {
    public <T> BaseResponse<T> jsonToSuccessResponse(T data) {
        return new BaseResponse<>(
                Status.SUCCESS.getStatusCode(),
                Status.SUCCESS.getStatus(),
                data
        );
    }

    public <T> BaseResponse<T> jsonToFailedResponse(T data) {
        return new BaseResponse<>(
                Status.FAILED.getStatusCode(),
                Status.FAILED.getStatus(),
                data
        );
    }

    public <T> BaseResponse<T> jsonToFailedResponse(T data, String message) {
        if (message == null) return this.jsonToFailedResponse(data);
        return new BaseResponse<>(
                Status.FAILED.getStatusCode(),
                message,
                data
        );
    }
}
