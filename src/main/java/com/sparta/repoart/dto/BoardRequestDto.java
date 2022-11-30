package com.sparta.repoart.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class BoardRequestDto {
    private String title;
    private String username;
    private String contents;
    private String password;
    }

