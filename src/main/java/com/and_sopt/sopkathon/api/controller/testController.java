package com.and_sopt.sopkathon.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping("/test") // HTTP GET 요청 처리
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("안녕하세요");
    }


    @PostMapping("/test/{id}") // HTTP GET 요청 처리
    public ResponseEntity<String> postTest(@PathVariable Long id) {
        return ResponseEntity.ok("안녕하세요 : "+id);
    }
}
