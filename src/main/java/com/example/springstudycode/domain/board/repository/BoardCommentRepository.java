package com.example.springstudycode.domain.board.repository;

import com.example.springstudycode.domain.board.entity.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardCommentRepository extends JpaRepository<BoardComment, Long> {
}
