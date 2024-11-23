package com.and_sopt.sopkathon.api.entity;

import com.and_sopt.sopkathon.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(name="content",nullable = false)
    private String content;

    @Column(name="image")
    private String image;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    @Builder
    public Board(String content,User user){
        this.content = content;
        this.user = user;
    }
}

