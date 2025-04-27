package com.muratesenkaya.travelApp.repository;

import com.muratesenkaya.travelApp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {}
