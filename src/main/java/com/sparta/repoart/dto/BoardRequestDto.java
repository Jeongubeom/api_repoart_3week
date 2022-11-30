package com.sparta.repoart.dto;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String title; //게시글 제목
    private String username; // 작성자명
    private String contents; //작성내용
    private String pass; //비밀번호
}
