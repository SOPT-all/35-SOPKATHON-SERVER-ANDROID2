package com.and_sopt.sopkathon.api.service;

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

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public void createBoard(final long userId, String content) {

        User savedUser = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER));

        Board board = Board.builder()
                .content(content)
                .user(savedUser)
                .build();

        boardRepository.save(board);

    }



    @Transactional(readOnly = true)
    public List<BoardsListResponseDto> getBoardsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER));
        List<Board> boards = boardRepository.findAllByUser(user);
        return boards.stream().map(BoardsListResponseDto::of).toList();
    }
}
