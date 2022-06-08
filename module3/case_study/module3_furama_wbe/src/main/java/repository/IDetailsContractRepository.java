package repository;

import model.AttachService;
import model.Contract;
import model.DetailsContract;

import java.util.List;

public interface IDetailsContractRepository {
    List<DetailsContract> getAllDetailsContract();

    void getCreateDetailsContract(DetailsContract detailsContract);

    List<Contract> getAllContract();
    List<AttachService> getAllAttachService();

    void getUpdateDetailsContract(DetailsContract detailsContract);

    DetailsContract findById(int id);

    void delete(int id);
}
