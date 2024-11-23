package com.and_sopt.sopkathon.api.dto.res;

import lombok.Builder;

@Builder
public record BoardRes(String createdAt, String content, String image) {
}
