package casestudy_module2.model;

public class House extends Facility{
    private String roomStand;
    private String numOfFloors;

    public House() {
    }

    public House(String iDFacility, String name, Double area, String cost, String maxPerson, String type, String roomStand, String numOfFloors) {
        super(iDFacility, name, area, cost, maxPerson, type);
        this.roomStand = roomStand;
        this.numOfFloors = numOfFloors;
    }

    public String getRoomStand() {
        return roomStand;
    }

    public void setRoomStand(String roomStand) {
        this.roomStand = roomStand;
    }

    public String getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(String numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    @Override
    public String toString() {
        return "House [" + super.toString()+
                "roomStand='" + roomStand + '\'' +
                ", numOfFloors='" + numOfFloors + '\'' +
                ']';
    }
}
