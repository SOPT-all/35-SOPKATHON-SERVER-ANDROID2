package com.and_sopt.sopkathon.api.controller;


import com.and_sopt.sopkathon.api.dto.req.BoardCreateReq;
import com.and_sopt.sopkathon.api.dto.res.BoardIdRes;
import com.and_sopt.sopkathon.api.dto.res.BoardsListResponseDto;
import com.and_sopt.sopkathon.api.dto.res.BoardRes;
import com.and_sopt.sopkathon.api.service.BoardService;
import com.and_sopt.sopkathon.global.exception.CustomException;
import com.and_sopt.sopkathon.global.response.ApiResponseDto;
import com.and_sopt.sopkathon.global.response.enums.ErrorCode;
import com.and_sopt.sopkathon.global.response.enums.SuccessCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/board/{userId}")
    private ApiResponseDto<BoardIdRes> createBoard(@PathVariable final long userId, @RequestBody BoardCreateReq request) {

        if (request.getContent() == null || request.getContent().trim().isEmpty()) {
            throw new CustomException(ErrorCode.BOARD_BAD_REQUEST);
        }

        return ApiResponseDto.success(SuccessCode.BOARD_POST_SUCCESS, boardService.createBoard(userId, request.getContent()));
    }


    @GetMapping("/boards/{userId}")
    public ResponseEntity<ApiResponseDto<List<BoardsListResponseDto>>> getBoardsByUserId(@PathVariable Long userId) {
        List<BoardsListResponseDto> boards = boardService.getBoardsByUserId(userId);
        return ResponseEntity.ok(ApiResponseDto.success(SuccessCode.BOARD_LIST_FOUND, boards));
    }
    @GetMapping("board/{boardId}")
    private ApiResponseDto<BoardRes> getBoard(@PathVariable final long boardId) {
        return ApiResponseDto.success(SuccessCode.BOARD_GET_SUCCESS,boardService.getBoard(boardId));
    }

}
