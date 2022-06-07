package service.impl;

import model.Contract;
import repository.IContractRepository;
import repository.impl.ContractRepository;
import service.IContractService;

import java.util.List;

public class ContractService implements IContractService {
    private IContractRepository iContractRepository = new ContractRepository();

    @Override
    public List<Contract> getAllContract() {
        return iContractRepository.getAllContract();
    }
}
