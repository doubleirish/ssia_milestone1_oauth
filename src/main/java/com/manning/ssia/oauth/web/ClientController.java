package com.manning.ssia.oauth.web;


import com.manning.ssia.oauth.jpa.Client;
import com.manning.ssia.oauth.jpa.ClientRepository;
import com.manning.ssia.oauth.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "/clients", produces = "application/json")
@CrossOrigin(origins = "*")
public class ClientController {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public Iterable<ClientDto> list() {


        PageRequest page = PageRequest.of(
                0, 12, Sort.by("name").ascending());

        return clientRepository
                .findAll(page)
                .getContent()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }


    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> byId(@PathVariable("id") Integer id) {
        Optional<Client> optClient = clientRepository.findById(id);
        if (optClient.isPresent()) {
            return new ResponseEntity<>(convertToDto(optClient.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    private ClientDto convertToDto(Client client) {
        return new ClientDto(client);
    }
}

