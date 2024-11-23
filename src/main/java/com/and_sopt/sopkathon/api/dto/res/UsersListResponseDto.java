package com.and_sopt.sopkathon.api.dto.res;

import com.and_sopt.sopkathon.api.entity.User;

public record UsersListResponseDto(
        long userId,
        String nickName,
        int level
) {

    public static UsersListResponseDto of (final User user){
        return new UsersListResponseDto(
                user.getUserId(),
                user.getNickName(),
                user.getLevel());
    }

}
