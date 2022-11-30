package com.sparta.repoart.controller;

import com.sparta.repoart.dto.BoardRequestDto;
import com.sparta.repoart.entity.Board;
import com.sparta.repoart.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class BoardController {

    private final BoardService boardService;


    @GetMapping("/api/post/search") //게시판 전체조회
    public List<Board> getBoard(){
        return boardService.getBoard();
    }

    @PostMapping("/api/post/create")
    public Board createBoard(@RequestBody BoardRequestDto requestDto){ //게시판 작성
        return boardService.createBoard(requestDto);
    }

    @DeleteMapping("api/post/delete/{id}") // 게시글 삭제
    public Long deleteBoard(@PathVariable Long id){
        return boardService.deleteBoard(id);
    }
}
