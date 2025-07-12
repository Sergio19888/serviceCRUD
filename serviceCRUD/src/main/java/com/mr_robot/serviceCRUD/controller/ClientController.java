package com.mr_robot.serviceCRUD.controller;

import com.mr_robot.serviceCRUD.DTO.ClientDTO;
import com.mr_robot.serviceCRUD.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;


    @PostMapping
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO clientDTO){
        ClientDTO created = clientService.create(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        ClientDTO updateClient = clientService.update(id,clientDTO);
        return ResponseEntity.ok(updateClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity <Page<ClientDTO>> getAllClients(Pageable pageable) {
        Page<ClientDTO> allClient = clientService.getAllClients(pageable);
        return ResponseEntity.ok(allClient);
    }
}
