package com.and_sopt.sopkathon.api.service;

import com.and_sopt.sopkathon.api.dto.res.BoardRes;
import com.and_sopt.sopkathon.api.dto.res.BoardsListResponseDto;
import com.and_sopt.sopkathon.api.entity.Board;
import com.and_sopt.sopkathon.api.entity.User;
import com.and_sopt.sopkathon.api.repository.BoardRepository;
import com.and_sopt.sopkathon.api.repository.UserRepository;
import com.and_sopt.sopkathon.global.exception.CustomException;
import com.and_sopt.sopkathon.global.response.enums.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class BoardService {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public void createBoard(final long userId, String content) {

        User savedUser = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        Board board = Board.builder()
                .content(content)
                .user(savedUser)
                .build();

        boardRepository.save(board);

    }

    public BoardRes getBoard(final long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));

        return BoardRes.builder()
                .createdAt(board.getCreatedAt().format(DATE_FORMATTER))
                .content(board.getContent())
                .image(board.getImage())
                .build();
    }



    @Transactional(readOnly = true)
    public List<BoardsListResponseDto> getBoardsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER));
        List<Board> boards = boardRepository.findAllByUser(user);
        return boards.stream().map(BoardsListResponseDto::of).toList();
    }
}
