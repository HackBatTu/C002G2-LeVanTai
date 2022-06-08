package model;

public class DetailsContract {
    private int id;
    private int numberContract;
    private Contract contract;
    private AttachService attachService;
    private int status;

    public DetailsContract(int id, int numberContract, Contract contract, AttachService attachService,int status) {
        this.id = id;
        this.numberContract = numberContract;
        this.contract = contract;
        this.attachService = attachService;
        this.status = status;
    }

    public DetailsContract() {
    }

    public DetailsContract(int id, int numberContract, Contract contract, AttachService attachService) {
        this.id = id;
        this.numberContract = numberContract;
        this.contract = contract;
        this.attachService = attachService;
    }

    public DetailsContract(int numberContract, Contract contract, AttachService attachService) {
        this.numberContract = numberContract;
        this.contract = contract;
        this.attachService = attachService;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(int numberContract) {
        this.numberContract = numberContract;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
