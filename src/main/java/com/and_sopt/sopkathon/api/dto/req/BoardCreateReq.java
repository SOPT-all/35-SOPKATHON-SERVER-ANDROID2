package com.and_sopt.sopkathon.api.dto.req;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class BoardCreateReq {

    private String content;

    @JsonCreator
    public BoardCreateReq(@JsonProperty("content") String content) {
        this.content = content;
    }

}
