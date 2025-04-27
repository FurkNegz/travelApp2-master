package com.muratesenkaya.travelApp.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private String comment;
    private String date;
    private Long userId;
    private Long routeId;
}
