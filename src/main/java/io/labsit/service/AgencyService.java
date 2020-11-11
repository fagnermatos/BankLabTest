package io.labsit.service;

import io.labsit.model.Agency;
import io.labsit.repository.AgencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgencyService {

    private final AgencyRepository repository;

    public List<Agency> findAll() {
        return repository.findAll();
    }

    public Agency saveOrUpdate(Agency agency) {
        return repository.save(agency);
    }
}