package com.and_sopt.sopkathon.api.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name="nickname" , nullable = false)
    private String nickName;

    @Column(name="level",nullable = false)
    private int level;

}