package service.impl;

import model.AttachService;
import model.Contract;
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

    @Override
    public void getCreateDetailsContract(DetailsContract detailsContract) {
        iDetailsContractRepository.getCreateDetailsContract(detailsContract);
    }

    @Override
    public List<Contract> getAllContract() {
        return iDetailsContractRepository.getAllContract();
    }

    @Override
    public List<AttachService> getAllAttachService() {
        return iDetailsContractRepository.getAllAttachService();
    }

    @Override
    public void getUpdateDetailsContract(DetailsContract detailsContract) {
        iDetailsContractRepository.getUpdateDetailsContract(detailsContract);
    }

    @Override
    public DetailsContract findById(int id) {
        return iDetailsContractRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        iDetailsContractRepository.delete(id);
    }
}
