package io.labsit.api;

import io.labsit.model.Agency;
import io.labsit.service.AgencyService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@Api("agencia")
@RequiredArgsConstructor
@RequestMapping("agencia")
public class AgencyResource {

    private final AgencyService service;

    @GetMapping
    @ResponseStatus(OK)
    public List<Agency> findAll() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Agency save(@RequestBody @Validated Agency agency) {
        return service.saveOrUpdate(agency);
    }
}
