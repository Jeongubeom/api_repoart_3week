package com.sparta.repoart.entity;

import com.sparta.repoart.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor

public class Board extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username; //private key 부분인 userName

    @Column(nullable = false)
    private String pass; //private key 부분인 pass

    @Column(nullable = false)
    private String title; // private title 부분인 title

    @Column(nullable = false)
    private String contents; //private key 부분인 contents

    public Board(BoardRequestDto requestDto){ //BoardRequestDto를 requestDto로 선언해서 해당 값을 받는다
        this.username = requestDto.getUsername(); // BoardRequestDto에서 Username을 가져와서 필드(get) username에 값을 넣는다
        this.contents = requestDto.getContents(); // BoardRequestDto에서 contnents을 가져와서(get) 필드 contents에 값을 넣는다
        this.title = requestDto.getTitle(); // BoardRequestDto에서 title을 가져와서(get) 필드 title에 값을 넣는다
        this.pass = requestDto.getPassword(); // BoardRequestDto에서 pass을 가져와서(get) 필드 pass에 값을 넣는다
    }
    public void updateBoard(BoardRequestDto requestDto){
        this.username = requestDto.getUsername(); // BoardRequestDto에서 Username을 가져와서 필드(get) username에 값을 넣는다
        this.contents = requestDto.getContents(); // BoardRequestDto에서 contnents을 가져와서(get) 필드 contents에 값을 넣는다
        this.title = requestDto.getTitle(); // BoardRequestDto에서 title을 가져와서(get) 필드 title에 값을 넣는다
        this.pass = requestDto.getPassword();

    }
}
