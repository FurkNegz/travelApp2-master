package com.muratesenkaya.travelApp.service;

import com.muratesenkaya.travelApp.dto.CommentDTO;
import com.muratesenkaya.travelApp.mapper.CommentMapper;
import com.muratesenkaya.travelApp.model.Comment;
import com.muratesenkaya.travelApp.model.Route;
import com.muratesenkaya.travelApp.model.User;
import com.muratesenkaya.travelApp.repository.CommentRepository;
import com.muratesenkaya.travelApp.repository.RouteRepository;
import com.muratesenkaya.travelApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final RouteRepository routeRepository;

    public CommentDTO createComment(CommentDTO commentDTO) {
        User user = userRepository.findById(commentDTO.getUserId()).orElseThrow();
        Route route = routeRepository.findById(commentDTO.getRouteId()).orElseThrow();
        Comment comment = CommentMapper.toEntity(commentDTO, user, route);
        Comment saved = commentRepository.save(comment);
        return CommentMapper.toDTO(saved);
    }

    public List<CommentDTO> getAllComments() {
        return commentRepository.findAll().stream()
                .map(CommentMapper::toDTO)
                .collect(Collectors.toList());
    }
}
