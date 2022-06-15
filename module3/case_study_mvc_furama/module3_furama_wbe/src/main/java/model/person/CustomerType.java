package model.person;

public class CustomerType {
    private int id;
    private String name;
    private int status;

    public CustomerType(int id, String name,int status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
    public CustomerType(int idCustomerType, String nameCusType) {
        this.id = idCustomerType;
        this.name = nameCusType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public CustomerType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String   toString() {
        return "CustomerType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
