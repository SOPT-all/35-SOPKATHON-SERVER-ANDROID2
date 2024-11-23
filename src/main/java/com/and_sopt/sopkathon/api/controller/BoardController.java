package com.and_sopt.sopkathon.api.controller;


import com.and_sopt.sopkathon.api.dto.req.BoardCreateReq;
import com.and_sopt.sopkathon.api.service.BoardService;
import com.and_sopt.sopkathon.global.exception.CustomException;
import com.and_sopt.sopkathon.global.response.ApiResponseDto;
import com.and_sopt.sopkathon.global.response.enums.ErrorCode;
import com.and_sopt.sopkathon.global.response.enums.SuccessCode;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/{userId}")
    private ApiResponseDto<?> createBoard(@PathVariable final long userId, @RequestBody BoardCreateReq request) {

        if (request.getContent() == null || request.getContent().trim().isEmpty()) {
            throw new CustomException(ErrorCode.BOARD_BAD_REQUEST);
        }
        boardService.createBoard(userId, request.getContent());
        return ApiResponseDto.success(SuccessCode.BOARD_POST_SUCCESS);
    }

}
