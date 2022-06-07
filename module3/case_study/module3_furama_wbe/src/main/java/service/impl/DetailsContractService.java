package service.impl;

import model.DetailsContract;
import repository.IDetailsContractRepository;
import repository.impl.DetailsContractRepository;
import service.IDetailsContractService;

import java.util.List;

public class DetailsContractService implements IDetailsContractService {
    private IDetailsContractRepository iDetailsContractRepository = new DetailsContractRepository();

    @Override
    public List<DetailsContract> getAllDetailsContract() {
        return  iDetailsContractRepository.getAllDetailsContract();
    }
}
