package com.and_sopt.sopkathon.api.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(name="created_at",nullable = false)
    private LocalDateTime createdAt;

    @Column(name="content",nullable = false)
    private String content;

    @Column(name="image")
    private String image;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;
}

