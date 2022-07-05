package com.link.service.impl;

import com.link.repository.IDetailsContractRepository;
import com.link.service.IDetailsContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailsContractService implements IDetailsContractService {

    @Autowired
    private IDetailsContractRepository iDetailsContractRepository;
}
