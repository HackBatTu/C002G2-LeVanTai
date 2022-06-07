package model;

public class ServiceType {
    private int id;
    private String name;
    private int status;

    public ServiceType(int id, String name,int status) {
        this.id = id;
        this.name = name;
        this.status=status;
    }

    public ServiceType(int serviceType, String serviceTypeName) {
        this.id = serviceType;
        this.name = serviceTypeName;
    } public ServiceType(int serviceType) {
        this.id = serviceType;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
