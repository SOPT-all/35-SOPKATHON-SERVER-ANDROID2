package com.and_sopt.sopkathon.api.service;

import com.and_sopt.sopkathon.api.dto.res.BoardIdRes;
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


@Service
@RequiredArgsConstructor
public class BoardService {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public BoardIdRes createBoard(final long userId, String content) {

        User savedUser = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        int count = getBoardLevel(userId);
        savedUser.setLevel(count);
        Board board = Board.builder()
                .content(content)
                .user(savedUser)
                .build();

        Board savedBoard = boardRepository.save(board);

        // 게시글 ID 반환
        return new BoardIdRes(savedBoard.getBoardId());
    }

    @Transactional
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
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        List<Board> boards = boardRepository.findAllByUser(user);
        return boards.stream().map(BoardsListResponseDto::of).toList();
    }

    //Board 개수에 따라 없데이트 하는 로직 post 들어올때 user의 level 에 ㅓ장
    public int getBoardLevel(Long userId) {
        // 사용자 조회
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        // 사용자의 게시글 수 조회
        int count = boardRepository.countByUser(user)+1;
        int newLevel;


        // 게시글 수에 따른 레벨 계산
        if (count >= 15) {
            newLevel = 5; // 5단계
        } else if (count >= 7) {
            newLevel = 4; // 4단계
        } else if (count >= 4) {
            newLevel = 3; // 3단계
        } else if (count >= 2) {
            newLevel = 2; // 2단계
        } else {
            newLevel = 1; // 기본 단계
        }


            user.setLevel(newLevel);
            userRepository.save(user);
        return newLevel;



    }

}
