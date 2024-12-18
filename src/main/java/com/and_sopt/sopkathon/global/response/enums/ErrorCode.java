package com.and_sopt.sopkathon.global.response.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //400 Bad Request
    BAD_REQUEST(400, HttpStatus.BAD_REQUEST, "유효한 요청이 아닙니다."),
    BOARD_BAD_REQUEST(400, HttpStatus.BAD_REQUEST, "내용은 비어있을 수 없습니다."),
    MISSING_REQUIRED_HEADER(400, HttpStatus.BAD_REQUEST, "필수 헤더가 누락되었습니다."),
    MISSING_REQUIRED_PARAMETER(400, HttpStatus.BAD_REQUEST, "필수 파라미터가 누락되었습니다."),
    //404 Not Found
    NOT_FOUND(404, HttpStatus.NOT_FOUND, "존재하지 않는 API입니다."),
    BOARD_NOT_FOUND(404, HttpStatus.NOT_FOUND, "존재하지 않는 게시글 입니다."),
    USER_NOT_FOUND(404, HttpStatus.NOT_FOUND, "존재하지 않는 User Id 입니다."),
    //405 Method Not Allowed
    METHOD_NOT_ALLOWED(405, HttpStatus.METHOD_NOT_ALLOWED, "지원하지 않는 메소드입니다."),
    //500 Internal Server Error
    INTERNAL_SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다.");

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
}
