package com.muratesenkaya.travelApp.dto;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class RouteDTO {
    private Long id;
    private String head;
    private String description;
    private Date date;
    private List<String> tags; // Sadece tag isimlerini listeledik
}



