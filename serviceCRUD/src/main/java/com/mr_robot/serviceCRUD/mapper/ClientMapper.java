package com.mr_robot.serviceCRUD.mapper;

import com.mr_robot.serviceCRUD.DTO.ClientDTO;
import com.mr_robot.serviceCRUD.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDTO(Client client);

    Client toEntity(ClientDTO clientDTO);
}