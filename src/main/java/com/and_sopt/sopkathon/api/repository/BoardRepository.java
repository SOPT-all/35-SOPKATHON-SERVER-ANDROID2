package com.and_sopt.sopkathon.api.repository;

import com.and_sopt.sopkathon.api.entity.Board;
import com.and_sopt.sopkathon.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {

    List<Board> findAllByUser(User user);

    int countByUser(User user);
}
