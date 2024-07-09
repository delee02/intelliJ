package com.example.simple_board.post.controller;

import com.example.simple_board.post.db.PostEntity;
import com.example.simple_board.post.model.PostRequest;
import com.example.simple_board.post.model.PostViewRequest;
import com.example.simple_board.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostApiController {

    private final PostService postService;

    // 글 작성하기
    @PostMapping("")
    public PostEntity create(
            @Valid
            @RequestBody PostRequest postRequest
    ){
        return postService.create(postRequest);
    }

    //특정 게시물 보기
    @PostMapping("/view")
    public PostEntity view(
            @Valid
            @RequestBody PostViewRequest postViewRequest
    ){
      return postService.view(postViewRequest);
    }

    //게시글 리스트 보기
    @GetMapping("/all")
    public List<PostEntity> list(

    ){
        return postService.all();
    }

    @PostMapping("/delete")
    public void delete(
            @Valid
            @RequestBody PostViewRequest postViewRequest
    ){
        postService .delete(postViewRequest);
    }

}
