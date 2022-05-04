package test_module2_java.casestudy.models.resort;

public class Room extends Facility {
    private String freeService;

//   Dịch vụ miễn phí đi kèm.
    public Room() {
    }

    public Room(String idFacility, String serviceName, Double area, Integer rentalCosts, Integer maxPerson, String rentalType, String freeService) {
        super(idFacility, serviceName, area, rentalCosts, maxPerson, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
    public String convertLine() {
        String line = super.convertLine()+","+this.freeService;
        return line;
    }
    @Override
    public String toString() {
        return "Room [ " +super.toString()+
                "freeService='" + freeService + '\'' +
                ']';
    }
}
