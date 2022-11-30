package com.sparta.repoart.service;


import com.sparta.repoart.dto.BoardRequestDto;
import com.sparta.repoart.entity.Board;
import com.sparta.repoart.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;// 데이터베이스 저장소 Boardreository에 저장

    @Transactional
    public Board createBoard(BoardRequestDto requestDto) { //포스팅
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return board;
    }

    @Transactional
    public List<Board> getBoard(){
        return boardRepository.findAll();
    }

    @Transactional
    public Long deleteBoard(Long id){ //삭제
        boardRepository.deleteById(id);
        return id;
    }
}

