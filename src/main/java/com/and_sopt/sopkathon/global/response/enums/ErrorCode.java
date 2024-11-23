package com.and_sopt.sopkathon.global.response.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //400 Bad Request
    BAD_REQUEST(40000, HttpStatus.BAD_REQUEST, "유효한 요청이 아닙니다."),
    NOT_FOUND_USER(40401, HttpStatus.NOT_FOUND, "존재하지 않는 User Id 입니다."),
    MISSING_REQUIRED_HEADER(40001, HttpStatus.BAD_REQUEST, "필수 헤더가 누락되었습니다."),
    MISSING_REQUIRED_PARAMETER(40002, HttpStatus.BAD_REQUEST, "필수 파라미터가 누락되었습니다."),
    //404 Not Found
    NOT_FOUND(40400, HttpStatus.NOT_FOUND, "존재하지 않는 API입니다."),
    //405 Method Not Allowed
    METHOD_NOT_ALLOWED(40500, HttpStatus.METHOD_NOT_ALLOWED, "지원하지 않는 메소드입니다."),
    //500 Internal Server Error
    INTERNAL_SERVER_ERROR(50000, HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다.");



    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
}
