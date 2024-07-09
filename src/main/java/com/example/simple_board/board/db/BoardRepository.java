package com.example.simple_board.board.db;

import com.example.simple_board.reply.db.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {


}
