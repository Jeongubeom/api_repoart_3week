package com.sparta.repoart.controller;

import com.sparta.repoart.dto.BoardRequestDto;
import com.sparta.repoart.entity.Board;
import com.sparta.repoart.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor

public class BoardController {

    private final BoardService boardService;


    @GetMapping("/api/post/search") //게시판 전체조회
    public List<Board> getBoard() {
        return boardService.getBoard();
    }

    @PostMapping("/api/post/create")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) { //게시판 작성
        return boardService.createBoard(requestDto);
    }

   /* @GetMapping("/api/post/search")
    public BoardResponseDto getBoard(@RequestParam Long id) {
        return boardService.getBoard(id);*/ //선택 게시글 조회 일단보류

    @DeleteMapping("api/post/delete/{id}") // 게시글 삭제
    public Long deleteBoard(@PathVariable Long id) {
        return boardService.deleteBoard(id);
    }

    @PutMapping("/api/post/update/{id}") //게시글 수정!
    public Long update(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        return boardService.update(id, requestDto);
        }
    @GetMapping("/api/post/search/{id}") //선택한 게시글보기
    public Optional<Board> getBoardOne(@PathVariable Long id) {
        return boardService.getBoardOne(id);
    }
}