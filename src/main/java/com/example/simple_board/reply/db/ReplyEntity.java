package com.example.simple_board.reply.db;

import com.example.simple_board.post.db.PostEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity(name = "reply")
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    // @ToString.Exclude 에 대해 https://velog.io/@buffet/TOString-%EA%B3%BC-TOString.Exclude%EC%97%90-%EB%8C%80%ED%95%B4%EC%84%9C 참조
    //private Long postId;
    private PostEntity post;// PostId x 이건 postId_id가 됨 -> post라고 해야 post_id로 됨

    private String userName;

    private String password;

    private String status;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime repliedAt;
}
