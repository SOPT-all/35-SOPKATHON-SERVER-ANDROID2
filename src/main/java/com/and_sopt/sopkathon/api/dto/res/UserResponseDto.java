package com.and_sopt.sopkathon.api.dto.res;

import com.and_sopt.sopkathon.api.entity.User;

public record UserResponseDto(
        long id,
        String nickname,
        int level
) {

    public static UserResponseDto of (final User user){
        return new UserResponseDto(
                user.getUserId(),
                user.getNickName(),
                user.getLevel());
    }

}
