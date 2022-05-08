package casestudy.models.resort;

public class Villa extends Facility {
    private String roomStandard;
    private Double poolArea;
    private Integer numberOfFloors;
//    Tiêu chuẩn phòng, Diện tích hồ bơi, Số tầng.


    public Villa() {
    }

    public Villa(String idFacility, String serviceName, Double area, Integer rentalCosts, Integer maxPerson, String rentalType, String roomStandard, Double poolArea, Integer numberOfFloors) {
        super(idFacility, serviceName, area, rentalCosts, maxPerson, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
    public String convertLine() {
        String line = super.convertLine()+","+this.roomStandard+","+this.poolArea+","+this.numberOfFloors;
        return line;
    }

    @Override
    public String toString() {
        return "Villa [ " + super.toString()+
                "roomStandard: " + roomStandard + '\'' +
                ", poolArea: " + poolArea +
                ", numberOfFloors: " + numberOfFloors +
                ']';
    }
}
