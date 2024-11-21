package com.and_sopt.sopkathon.global.response.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {

    //200 OK
    MOVIE_TIMELINE_GET_SUCCESS(20001, HttpStatus.OK, "게시글이 성공적으로 생성되었습니다.");

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
}
