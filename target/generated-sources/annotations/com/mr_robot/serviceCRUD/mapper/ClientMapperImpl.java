package com.mr_robot.serviceCRUD.mapper;

import com.mr_robot.serviceCRUD.DTO.ClientDTO;
import com.mr_robot.serviceCRUD.model.Client;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-25T18:28:39+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDTO toDTO(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId( client.getId() );
        clientDTO.setName( client.getName() );
        clientDTO.setSurName( client.getSurName() );
        clientDTO.setEmail( client.getEmail() );
        clientDTO.setPhoneNumber( client.getPhoneNumber() );

        return clientDTO;
    }

    @Override
    public Client toEntity(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDTO.getId() );
        client.setName( clientDTO.getName() );
        client.setSurName( clientDTO.getSurName() );
        client.setEmail( clientDTO.getEmail() );
        client.setPhoneNumber( clientDTO.getPhoneNumber() );

        return client;
    }
}
