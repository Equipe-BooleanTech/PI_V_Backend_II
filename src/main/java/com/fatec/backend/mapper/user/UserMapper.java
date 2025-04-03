package com.fatec.backend.mapper.user;

import com.fatec.backend.DTO.user.UserDTO;
import com.fatec.backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDate.now())") // Default since not in source
    @Mapping(source = "name", target = "name")
    @Mapping(source = "lastname", target = "lastname")
    @Mapping(source = "phone", target = "phone") // Matches the casing in User class
    @Mapping(source = "birthdate", target = "birthdate")
    @Mapping(source = "vehicles", target = "vehicles")
    UserDTO toUserDTO(User user);

    User toUser(UserDTO userDTO);
}