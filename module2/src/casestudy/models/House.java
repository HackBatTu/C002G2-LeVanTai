package casestudy.models;

public class House extends Facility {
    private String roomStandard;
    private Integer numberOfFloors;
//    Tên dịch vụ, Diện tích sử dụng, Chi phí thuê, Số lượng người tối đa, Kiểu thuê
//    : Tiêu chuẩn phòng, Số tầng.
    public House() {
    }

    public House(String roomStandard, Integer numberOfFloors) {
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public House(Integer id,String serviceName, Integer area, Integer rentalCosts, Integer maxPerson, String rentalType, String roomStandard, Integer numberOfFloors) {
        super(id,serviceName, area, rentalCosts, maxPerson, rentalType);
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

    @Override
    public String toString() {
        return "House [" +super.toString()+
                "roomStandard='" + roomStandard + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                ']';
    }
}
