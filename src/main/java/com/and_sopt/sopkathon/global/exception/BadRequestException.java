package com.and_sopt.sopkathon.global.exception;


import com.and_sopt.sopkathon.global.response.enums.ErrorCode;

public class BadRequestException extends CustomException {
    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }
}
