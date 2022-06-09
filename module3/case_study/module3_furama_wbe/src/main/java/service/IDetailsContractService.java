package service;

import model.contract.AttachService;
import model.contract.Contract;
import model.contract.DetailsContract;

import java.util.List;

public interface IDetailsContractService {
    List<DetailsContract> getAllDetailsContract();

    void getCreateDetailsContract(DetailsContract detailsContract);

    List<Contract> getAllContract();

    List<AttachService> getAllAttachService();

    void getUpdateDetailsContract(DetailsContract detailsContract);

    DetailsContract findById(int id);

    void delete(int id);

    List<DetailsContract> searchById(String id);
}
