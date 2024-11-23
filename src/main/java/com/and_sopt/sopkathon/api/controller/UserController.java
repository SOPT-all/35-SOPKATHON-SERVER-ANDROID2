package com.and_sopt.sopkathon.api.controller;


import com.and_sopt.sopkathon.api.dto.res.UserResponseDto;
import com.and_sopt.sopkathon.api.dto.res.UsersListResponseDto;
import com.and_sopt.sopkathon.api.service.UserService;
import com.and_sopt.sopkathon.global.response.ApiResponseDto;
import com.and_sopt.sopkathon.global.response.enums.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponseDto<UserResponseDto>> getUserById(@PathVariable final long userId) {
        UserResponseDto userResponse = userService.findUserById(userId);
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.USER_FOUND, userResponse));
    }

    @GetMapping("/users")
    public ResponseEntity<ApiResponseDto<List<UsersListResponseDto>>> getUsers() { // 반환 타입 명확화
        List<UsersListResponseDto> userResponses = userService.getAllUsers();
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.USER_LIST_FOUND, userResponses));
    }
}