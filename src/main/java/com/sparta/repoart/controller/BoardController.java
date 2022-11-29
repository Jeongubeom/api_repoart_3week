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

    @PostMapping("/api/board/posts")  //1. 게시글 작성
    public Board createBoard(@RequestBody BoardRequestDto boardRequestDto){
        return boardService.createBoard(boardRequestDto);
    }

    @GetMapping("/api/board/posts{name}")  //2. 선택한 게시글 조회
    public List<Board> getBoard(){
        return boardService.getBoard;
    }

    @PutMapping("/apt/board/posts{id}") //3. 선택한 게시글 삭제
    public Long updateBoard(@PathVariable String name, @RequestBody BoardRequestDto boardRequestDto){
        return boardService.update(boardRequestDto);
    }
}
