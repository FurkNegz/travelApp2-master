package com.muratesenkaya.travelApp.mapper;

import com.muratesenkaya.travelApp.dto.UserDTO;
import com.muratesenkaya.travelApp.model.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setUserName(user.getUserName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setPassword("123456"); // Default password verebiliriz veya başka yöntemle ayarlanır
        return user;
    }
}
