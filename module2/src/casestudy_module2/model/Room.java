package casestudy_module2.model;

public class Room extends Facility{
    private String serviceFree;

    public Room() {
    }

    public Room(String iDFacility, String name, Double area, String cost, String maxPerson, String type, String serviceFree) {
        super(iDFacility, name, area, cost, maxPerson, type);
        this.serviceFree = serviceFree;
    }

    public String getServiceFree() {
        return serviceFree;
    }

    public void setServiceFree(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    @Override
    public String toString() {
        return "Room [" + super.toString()+
                "serviceFree='" + serviceFree + '\'' +
                ']';
    }
}
