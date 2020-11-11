package io.labsit.api;

import io.labsit.model.Client;
import io.labsit.service.ClientService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@Api("clientes")
@RequiredArgsConstructor
@RequestMapping("clientes")
public class ClientResource {

    private final ClientService service;

    @GetMapping
    @ResponseStatus(OK)
    public List<Client> findAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Client save(@RequestBody @Validated Client client) {
        return service.saveOrUpdate(client);
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public Client update(@PathVariable("id") Long id, @RequestBody @Validated Client client) {
        if (!id.equals(client.getId())) {
            throw new ResponseStatusException(CONFLICT, "O id informado não corresponde com o id do cliente");
        }
        return service.saveOrUpdate(client);
    }
}
