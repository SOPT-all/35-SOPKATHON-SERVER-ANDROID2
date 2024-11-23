package com.and_sopt.sopkathon.global.response.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessCode {

    //200 OK
    USER_FOUND(200, HttpStatus.OK, "유저를 성공적으로 찾았습니다."),
    USER_LIST_FOUND(200, HttpStatus.OK, "유저 목록을 성공적으로 찾았습니다."),
    BOARD_POST_SUCCESS(200, HttpStatus.OK, "게시글이 성공적으로 생성되었습니다."),
    BOARD_GET_SUCCESS(200, HttpStatus.OK, "게시글을 성공적으로 찾았습니다."),
    BOARD_LIST_FOUND(200, HttpStatus.OK, "게시글 목록을 성공적으로 찾았습니다");



    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
}
