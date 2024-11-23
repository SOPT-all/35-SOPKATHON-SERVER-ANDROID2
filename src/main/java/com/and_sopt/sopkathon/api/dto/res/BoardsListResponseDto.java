package com.and_sopt.sopkathon.api.dto.res;

import com.and_sopt.sopkathon.api.entity.Board;

import java.time.format.DateTimeFormatter;

public record BoardsListResponseDto(
        long boardId,
        String content,
        String createdAt,
        String image
) {
    public static BoardsListResponseDto of(Board board) {
        return new BoardsListResponseDto(
                board.getBoardId(),
                board.getContent(),
                board.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")),
                board.getImage()
        );
    }
}