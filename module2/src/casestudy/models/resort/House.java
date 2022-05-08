package casestudy.models.resort;

public class House extends Facility {
    private String roomStandard;
    private Integer numberOfFloors;

//    : Tiêu chuẩn phòng, Số tầng.
    public House() {
    }

    public House(String idFacility, String serviceName, Double area, Integer rentalCosts, Integer maxPerson, String rentalType, String roomStandard, Integer numberOfFloors) {
        super(idFacility, serviceName, area, rentalCosts, maxPerson, rentalType);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
    public String convertLine() {
        String line = super.convertLine()+
                ","+this.roomStandard+
                ","+this.numberOfFloors;
        return line;
    }

    @Override
    public String toString() {
        return "House [ " + super.toString()+
                "roomStandard='" + roomStandard + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                ']';
    }
}
