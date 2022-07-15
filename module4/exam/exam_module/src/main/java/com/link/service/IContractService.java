package com.link.service;

import com.link.model.Contract;
import com.link.model.ContractCheckTotal;
import com.link.model.Room;

import java.util.List;

public interface IContractService {

    List<Contract> findAll();

    List<Room> findAllRoom();

    void save(Contract contract);

    void deleteById(String id);
}
