package com.example.simple_board.board.contoller;

import com.example.simple_board.board.db.BoardEntity;
import com.example.simple_board.board.model.BoardDto;
import com.example.simple_board.board.model.BoardRequest;
import com.example.simple_board.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("")
    public BoardDto create(
            @Valid
            @RequestBody BoardRequest boardRequest
    ){
        return boardService.create(boardRequest);
    }

    @GetMapping("/all")
    public List<BoardEntity> list(){
        return boardService.all();
    }
}
