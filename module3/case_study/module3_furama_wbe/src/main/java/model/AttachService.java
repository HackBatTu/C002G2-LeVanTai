package model;

public class AttachService {
    private int id;
    private String name;
    private double cost;
    private String unit;
    private String attachStatus;
    private int status;

    public AttachService(int attachServiceId, String attachServiceName) {
        this.id = attachServiceId;
        this.name = attachServiceName;
    }

    public AttachService(int attachServiceId) {
        this.id = attachServiceId;
    }
    public AttachService(int attachServiceId,String attachServiceName,double attachServiceCost,String attachServiceUnit,String attachServiceStatus){
        this.id = attachServiceId;
        this.name = attachServiceName;
        this.cost = attachServiceCost;
        this.unit = attachServiceUnit;
        this.attachStatus = attachServiceStatus;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AttachService(int id, String name, double cost, String unit, String attachStatus,int status) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.attachStatus = attachStatus;
        this.status = status;
    }

    public AttachService() {
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAttachStatus() {
        return attachStatus;
    }

    public void setAttachStatus(String attachStatus) {
        this.attachStatus = attachStatus;
    }
}
