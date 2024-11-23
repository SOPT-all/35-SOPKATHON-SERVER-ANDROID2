package com.and_sopt.sopkathon.api.dto.req;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateReq {

    private String content;

    // 기본 생성자 추가
    public CreateReq() {
    }

    @JsonCreator
    public CreateReq(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
