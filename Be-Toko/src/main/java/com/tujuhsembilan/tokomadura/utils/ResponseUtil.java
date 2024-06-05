package com.tujuhsembilan.tokomadura.utils;

import com.tujuhsembilan.tokomadura.dto.ResponseUtil79;
import com.tujuhsembilan.tokomadura.utils.Constant.CommonConstant.ErrorCodeConstant;

public class ResponseUtil {
    
    public static ResponseUtil79 success(String message){
        return ResponseUtil79.builder()
            .errorCode(ErrorCodeConstant.SUCCESS)
            .message(message)
            .result(null)
            .build();
    }

    public static ResponseUtil79 success(String message, Object result){
        return ResponseUtil79.builder()
            .errorCode(ErrorCodeConstant.SUCCESS)
            .message(message)
            .result(result)
            .build();
    }

    public static ResponseUtil79 failed(String message){
        return ResponseUtil79.builder()
            .errorCode(ErrorCodeConstant.ERROR)
            .message(message)
            .result(null)
            .build();
    }

    public static ResponseUtil79 failed(String message, Object result){
        return ResponseUtil79.builder()
            .errorCode(ErrorCodeConstant.ERROR)
            .message(message)
            .result(result)
            .build();
    }
}
