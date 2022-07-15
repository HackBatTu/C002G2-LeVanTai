package com.link.service;

import com.link.model.Contract;
import com.link.model.ContractCheckTotal;
import com.link.model.Room;
import com.link.repository.IContractRepository;
import com.link.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService{

    @Autowired
    private IContractRepository iContractRepository;

    @Autowired
    private IRoomRepository iRoomRepository;


    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAllContract();
    }

    @Override
    public List<Room> findAllRoom() {
        return iRoomRepository.findAllRoom();
    }

    @Override
    public void save(Contract contract) {
        this.iContractRepository.save(contract);
        contract.getRoom().setStatus(1);
    }

    @Override
    public void deleteById(String id) {
        this.iContractRepository.deleteByIdContract(id);
    }
}
