package com.sparta.repoart.service;


import com.sparta.repoart.dto.BoardRequestDto;
import com.sparta.repoart.dto.ResponseCreateDto;
import com.sparta.repoart.dto.ResponseDeleteUpdateDto;
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
    public List<Board> getBoard(){ //List 배열 선언 후 BoardController에서 값을 받아온다
        return boardRepository.findAllByOrderByModifiedAtDesc();//BoardController에서 받아 온 값을 모두 찾은 다음 내림차순 정렬
    }

    @Transactional(readOnly = true) // 선택게시글찾기
    public Optional<Board> getBoardOne(Long id){ //이부분은 나도 잘.....
        return boardRepository.findById(id); //findById에서 id값을 받아온것을 boardRepository에 저장을 한다.
    }


    @Transactional
    public ResponseCreateDto createBoard(BoardRequestDto requestDto) { //포스팅
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return new ResponseCreateDto(board);
    }

        public ResponseCreateDto update (Long id, BoardRequestDto requestDto) {
            Board board = boardRepository.findById(id).orElseThrow( //board에 boardRepository에서 .findById(id)를 찾는다 없으면 .orElseThrow로 없다는 값을 던진다
                    () -> new IllegalArgumentException("아이디가 없습니다") // 값이 없다고 msg를 띄운다
            );
            if (requestDto.getPassword().equals(board.getPass())) { // 만약에 클라이언트에서 다시 요청한 requestDto에서 .getPassward값이 .equals 똑같다면 지금 endtity에 저장된 board에서 가져온 .getPass와
                board.updateBoard(new ResponseCreateDto(board)); // board에 있는 .updateBoard에 클라이언트에서 새로 요청받은 requestDto의 값으로 교체해라
            }
            boardRepository.findAllByOrderByModifiedAtDesc(); // 교체하고 다시 내림차순 정렬
                return new ResponseCreateDto(board);

        }

   /* public ResponseDeleteUpdateDto update (Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow( //board에 boardRepository에서 .findById(id)를 찾는다 없으면 .orElseThrow로 없다는 값을 던진다
                () -> new IllegalArgumentException("아이디가 없습니다") // 값이 없다고 msg를 띄운다
        );
        if (requestDto.getPassword().equals(board.getPass())) { // 만약에 클라이언트에서 다시 요청한 requestDto에서 .getPassward값이 .equals 똑같다면 지금 endtity에 저장된 board에서 가져온 .getPass와
            board.updateBoard(requestDto); // board에 있는 .updateBoard에 클라이언트에서 새로 요청받은 requestDto의 값으로 교체해라
        }
        boardRepository.findAllByOrderByModifiedAtDesc(); // 교체하고 다시 내림차순 정렬
        return board.getId();

    }*/
    @Transactional
    public ResponseCreateDto deleteBoard (Long id){ //삭제
        Board board = checkBoard(boardRepository, id);
        boardRepository.deleteById(id);
        return new ResponseCreateDto() ;
    }

    private Board checkBoard(BoardRepository boardRepository, Long id) {
        return boardRepository.findById(id).orElseThrow(
                ()->new RuntimeException("게시글 삭제")
        );
    }

}


