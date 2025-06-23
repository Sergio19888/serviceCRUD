package com.mr_robot.serviceCRUD.service;

import com.mr_robot.serviceCRUD.DTO.ClientDTO;
import com.mr_robot.serviceCRUD.mapper.ClientMapper;
import com.mr_robot.serviceCRUD.model.Client;
import com.mr_robot.serviceCRUD.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientService {


    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;


    public ClientDTO create(ClientDTO clientDTO) {
        Client client = clientMapper.toEntity(clientDTO);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toDTO(savedClient);
    }

    public ClientDTO update(Long id, ClientDTO clientDTO) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Такого клиента нет"));
        existingClient.setName(clientDTO.getName());
        existingClient.setSurName(clientDTO.getSurName());
        existingClient.setEmail(clientDTO.getEmail());
        existingClient.setPhoneNumber(clientDTO.getPhoneNumber());

        Client updateClient = clientRepository.save(existingClient);
        return clientMapper.toDTO(updateClient);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream().map(clientMapper::toDTO).collect(Collectors.toList());
    }

}
