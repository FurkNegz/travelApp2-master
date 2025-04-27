package com.muratesenkaya.travelApp.repository;

import com.muratesenkaya.travelApp.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {}
