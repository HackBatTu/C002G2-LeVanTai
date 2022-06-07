package model;

public class RentType {
    private int id;
    private String name;
    private int status;

    public RentType(int id, String name,int status) {
        this.id = id;
        this.name = name;
        this.status=status;
    }

    public RentType(int rentType, String rentTypeName) {
        this.id = rentType;
        this.name = rentTypeName;
    }
    public RentType(int rentType) {
        this.id = rentType;
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
