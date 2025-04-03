package com.fatec.backend.DTO.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatec.backend.DTO.vehicle.VehicleDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record UserDTO(UUID id,
                      String email,
                      String username,
                      @JsonIgnore String password,
                      LocalDate createdAt,
                      String name,
                      String lastname,
                      String phone,
                      String birthdate,
                      List<VehicleDTO> vehicles) {
}