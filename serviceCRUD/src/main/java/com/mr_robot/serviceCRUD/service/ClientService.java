package com.mr_robot.serviceCRUD.service;

import com.mr_robot.serviceCRUD.DTO.ClientDTO;
import com.mr_robot.serviceCRUD.exception.CustomErrorException;
import com.mr_robot.serviceCRUD.mapper.ClientMapper;
import com.mr_robot.serviceCRUD.model.Client;
import com.mr_robot.serviceCRUD.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class ClientService {


    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;


    public ClientDTO create(ClientDTO clientDTO) {
        if(clientRepository.existsByEmail(clientDTO.getEmail())){
            throw new CustomErrorException("Такой email уже существует");
        }
        if(clientRepository.existsByPhoneNumber(clientDTO.getPhoneNumber())){
            throw new CustomErrorException("Такой телефон уже существует");
        }
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
    public Page<ClientDTO> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable).map(clientMapper::toDTO);
    }

}
