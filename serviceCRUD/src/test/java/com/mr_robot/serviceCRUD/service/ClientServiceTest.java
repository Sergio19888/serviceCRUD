package com.mr_robot.serviceCRUD.service;

import com.mr_robot.serviceCRUD.DTO.ClientDTO;
import com.mr_robot.serviceCRUD.mapper.ClientMapper;
import com.mr_robot.serviceCRUD.model.Client;
import com.mr_robot.serviceCRUD.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientService clientService;

    @Test
    void create_shouldSaveClientAndReturnDTO() {
        // given
        ClientDTO dto = new ClientDTO();
        dto.setName("Иван");
        dto.setSurName("Иванов");
        dto.setEmail("ivan@example.com");
        dto.setPhoneNumber("123456789");

        Client clientEntity = new Client();
        clientEntity.setName("Иван");
        clientEntity.setSurName("Иванов");
        clientEntity.setEmail("ivan@example.com");
        clientEntity.setPhoneNumber("123456789");

        Client savedClient = new Client();
        savedClient.setId(1L);
        savedClient.setName("Иван");
        savedClient.setSurName("Иванов");
        savedClient.setEmail("ivan@example.com");
        savedClient.setPhoneNumber("123456789");

        ClientDTO expectedDTO = new ClientDTO();
        expectedDTO.setId(1L);
        expectedDTO.setName("Иван");
        expectedDTO.setSurName("Иванов");
        expectedDTO.setEmail("ivan@example.com");
        expectedDTO.setPhoneNumber("123456789");

        when(clientRepository.existsByEmail("ivan@example.com")).thenReturn(false);
        when(clientRepository.existsByPhoneNumber("123456789")).thenReturn(false);
        when(clientMapper.toEntity(dto)).thenReturn(clientEntity);
        when(clientRepository.save(clientEntity)).thenReturn(savedClient);
        when(clientMapper.toDTO(savedClient)).thenReturn(expectedDTO);

        // when
        ClientDTO result = clientService.create(dto);

        // then
        assertNotNull(result);
        assertEquals("Иван", result.getName());
        assertEquals("Иванов", result.getSurName());
        assertEquals("ivan@example.com", result.getEmail());

        verify(clientRepository).save(clientEntity);
    }
}
