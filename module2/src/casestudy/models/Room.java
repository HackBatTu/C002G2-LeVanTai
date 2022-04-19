package casestudy.models;

public class Room extends Facility {
    private String freeService;

//    Tên dịch vụ, Diện tích sử dụng, Chi phí thuê, Số lượng người tối đa, Kiểu thuê
//   Dịch vụ miễn phí đi kèm.
    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String serviceName, Integer area, Integer rentalCosts, Integer maxPerson, String rentalType, String freeService) {
        super(serviceName, area, rentalCosts, maxPerson, rentalType);
        this.freeService = freeService;
    }
    public Room() {

    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room [" +super.toString()+
                "freeService='" + freeService + '\'' +
                ']';
    }
}
