package com.muratesenkaya.travelApp.repository;

import com.muratesenkaya.travelApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
