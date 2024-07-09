package com.example.simple_board.board.service;

import com.example.simple_board.board.db.BoardEntity;
import com.example.simple_board.board.model.BoardDto;
import com.example.simple_board.post.service.PostConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BoardConverter {

    private final PostConverter postConverter;
    public BoardDto toDto(BoardEntity boardEntity){

        var postList = boardEntity.getPostList().stream()
                .map(postEntity -> {
                    return postConverter.toDto(postEntity);
                })
                .collect(Collectors.toList());

        return BoardDto.builder()
                .id(boardEntity.getId())
                .boardName(boardEntity.getBoardName())
                .status(boardEntity.getStatus())
                .postList(postList)
                .build();
    }
}
