package com.example.simple_board.reply.service;

import com.example.simple_board.post.db.PostRepository;
import com.example.simple_board.reply.db.ReplyEntity;
import com.example.simple_board.reply.db.ReplyRepository;
import com.example.simple_board.reply.model.ReplyRequest;
import jakarta.persistence.PostRemove;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final PostRepository postRepository;
    public ReplyEntity create(
            ReplyRequest replyRequest
    ){
        var optionalPostEntity = postRepository.findById(replyRequest.getPostId());
        if(optionalPostEntity.isEmpty()){
            throw new RuntimeException("게시물이 존재하지 않습니다."+replyRequest.getPostId());
        }
        var entity = ReplyEntity.builder()
                .post(optionalPostEntity.get())
                .userName(replyRequest.getUserName())
                .password(replyRequest.getPassword())
                .status("REGISTERED")
                .content(replyRequest.getContent())
                .title(replyRequest.getTitle())
                .repliedAt(LocalDateTime.now())
                .build();

        return replyRepository.save(entity);
    }

    public List<ReplyEntity> findAllReplyByPostId(Long postId){
        return replyRepository.findAllByPostIdAndStatusOrderByIdDesc(postId, "REGISTERED");
    }
}
