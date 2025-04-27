package com.muratesenkaya.travelApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;


@Entity
@Table(name = "location")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DecimalMin(value = "36.0", message = "Latitude must be at least 36.0")
    @DecimalMax(value = "42.0", message = "Latitude must be at most 42.0")
    private Double latitude;

    @DecimalMin(value = "26.0", message = "Longitude must be at least 26.0")
    @DecimalMax(value = "45.0", message = "Longitude must be at most 45.0")
    private Double longitude;



    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
}
