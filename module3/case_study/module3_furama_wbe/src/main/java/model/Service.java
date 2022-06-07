package model;

public class Service {
    private int id;
    private String name;
    private int area;
    private double cost;
    private int maxPerson;
    private String roomStandard;
    private String anotherConvenient;
    private double poolArea;
    private int numOfFloors;
    private RentType rentType;
    private ServiceType serviceType;
    private int status;

    public Service(int id, String name, int area, double cost, int maxPerson, String roomStandard, String anotherConvenient, double poolArea, int numOfFloors, RentType rentType, ServiceType serviceType,int status) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPerson = maxPerson;
        this.roomStandard = roomStandard;
        this.anotherConvenient = anotherConvenient;
        this.poolArea = poolArea;
        this.numOfFloors = numOfFloors;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.status = status;
    }

    public Service(int id,String name, int area, double cost, int maxPerson, String roomStandard, String anotherConvenient, double poolArea, int numberOfFloors, RentType rentType, ServiceType serviceType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPerson = maxPerson;
        this.roomStandard = roomStandard;
        this.anotherConvenient = anotherConvenient;
        this.poolArea = poolArea;
        this.numOfFloors = numberOfFloors;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }
    public Service(String name, int area, double cost, int maxPerson, String roomStandard, String anotherConvenient, double poolArea, int numberOfFloors, RentType rentType, ServiceType serviceType) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPerson = maxPerson;
        this.roomStandard = roomStandard;
        this.anotherConvenient = anotherConvenient;
        this.poolArea = poolArea;
        this.numOfFloors = numberOfFloors;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }

    public Service(int serviceId, String serviceName) {
        this.id = serviceId;
        this.name = serviceName;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getAnotherConvenient() {
        return anotherConvenient;
    }

    public void setAnotherConvenient(String anotherConvenient) {
        this.anotherConvenient = anotherConvenient;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
