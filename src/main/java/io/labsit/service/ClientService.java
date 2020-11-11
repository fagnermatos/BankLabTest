package io.labsit.service;

import io.labsit.model.Client;
import io.labsit.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client saveOrUpdate(Client client) {
        return repository.save(client);
    }
}