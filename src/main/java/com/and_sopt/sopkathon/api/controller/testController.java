package com.and_sopt.sopkathon.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping("/test") // HTTP GET 요청 처리
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("안녕하세요");
    }
}