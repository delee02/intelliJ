package com.example.simple_board.post.db;

import com.example.simple_board.board.db.BoardEntity;
import com.example.simple_board.reply.db.ReplyEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore //boradEntity가 무한으로 entity불러오기 때문에 여기서 json으로 안만든다고 어노테이션
    //private Long boardId;
    private BoardEntity board;

    private String userName;

    private String password;

    private String email;

    private String status;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime postedAt;

   // @Transient //데이터베이스의 컬럼으로 인식하지 않게 하는 annotation
    @OneToMany(
            mappedBy = "post"
    )
    private List<ReplyEntity> replyList = List.of();


}
