package com.sparta.repoart.service;


import com.sparta.repoart.dto.BoardRequestDto;
import com.sparta.repoart.entity.Board;
import com.sparta.repoart.repository.BoardRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;// 데이터베이스 저장소 Boardreository에 저장

    @Transactional(readOnly = true) // 전체게시글 찾기
    public List<Board> getBoard(){
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional(readOnly = true) // 전체게시글 찾기
    public Optional<Board> getBoardOne(@PathVariable Long id){
        return boardRepository.findById(id);
    }


    @Transactional
    public Board createBoard(BoardRequestDto requestDto) { //포스팅
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return board;
    }

        @Transactional
        public Long update (Long id, BoardRequestDto requestDto) {
            Board board = boardRepository.findById(id).orElseThrow(
                    () -> new IllegalArgumentException("아이디가 없습니다")
            );
            if (requestDto.getPassword().equals(board.getPass())) {
                board.updateBoard(requestDto);
            }
                return board.getId();

        }
    @Transactional
    public Long deleteBoard (Long id){ //삭제
        boardRepository.deleteById(id);
        return id;
    }

}


