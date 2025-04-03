package com.fatec.backend.mapper.vehicle;

import com.fatec.backend.DTO.vehicle.VehicleDTO;
import com.fatec.backend.model.Vehicle;
import com.fatec.backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper
public interface VehicleMapper {
    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

    @Mapping(source = "uuid", target = "id")
    @Mapping(target = "userId", ignore = true)
    VehicleDTO ToVehicleDTO(Vehicle vehicle);

    @Mapping(source = "id", target = "uuid")
    @Mapping(target = "user", ignore = true) 
    Vehicle ToVehicle(VehicleDTO vehicleDTO);
    
    default UUID mapUserToId(User user) {
        return user != null ? user.getId() : null;
    }
}