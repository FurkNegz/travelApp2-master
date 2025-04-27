package com.muratesenkaya.travelApp.mapper;

import com.muratesenkaya.travelApp.dto.CommentDTO;
import com.muratesenkaya.travelApp.model.Comment;
import com.muratesenkaya.travelApp.model.Route;
import com.muratesenkaya.travelApp.model.User;

public class CommentMapper {

    public static CommentDTO toDTO(Comment comment) {
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setComment(comment.getComment());
        dto.setDate(comment.getDate());
        dto.setUserId(comment.getUser().getId());
        dto.setRouteId(comment.getRoute().getId());
        return dto;
    }

    public static Comment toEntity(CommentDTO dto, User user, Route route) {
        Comment comment = new Comment();
        comment.setId(dto.getId());
        comment.setComment(dto.getComment());
        comment.setDate(dto.getDate());
        comment.setUser(user);
        comment.setRoute(route);
        return comment;
    }
}
