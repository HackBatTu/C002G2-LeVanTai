package casestudy_module2.model;

import org.omg.PortableInterceptor.SUCCESSFUL;

public class Villa extends Facility{
    private String roomStand;
    private Double poolArea;
    private String numOfFloors;

    public Villa() {
    }

    public Villa(String iDFacility, String name, Double area, String cost, String maxPerson, String type, String roomStand, Double poolArea, String numOfFloors) {
        super(iDFacility, name, area, cost, maxPerson, type);
        this.roomStand = roomStand;
        this.poolArea = poolArea;
        this.numOfFloors = numOfFloors;
    }

    public String getRoomStand() {
        return roomStand;
    }

    public void setRoomStand(String roomStand) {
        this.roomStand = roomStand;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(String numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    @Override
    public String toString() {
        return "Villa [" + super.toString()+
                "roomStand='" + roomStand + '\'' +
                ", poolArea=" + poolArea +
                ", numOfFloors='" + numOfFloors + '\'' +
                '}';
    }
}
