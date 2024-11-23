package com.and_sopt.sopkathon.api.service;

import com.and_sopt.sopkathon.api.dto.res.UserResponseDto;
import com.and_sopt.sopkathon.api.dto.res.UsersListResponseDto;
import com.and_sopt.sopkathon.api.entity.User;
import com.and_sopt.sopkathon.api.repository.UserRepository;
import com.and_sopt.sopkathon.global.exception.CustomException;
import com.and_sopt.sopkathon.global.response.enums.ErrorCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto findUserById(final long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        return UserResponseDto.of(user);
    }

    @Transactional
    public List<UsersListResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UsersListResponseDto::of)
                .toList();
    }


}