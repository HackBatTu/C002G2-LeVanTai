package casestudy_module2.model;

public abstract class Facility {
    private String iDFacility;
    private String name;
    private Double area;
    private String cost;
    private String maxPerson;
    private String type;

    public Facility() {
    }

    public Facility(String iDFacility, String name, Double area, String cost, String maxPerson, String type) {
        this.iDFacility = iDFacility;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPerson = maxPerson;
        this.type = type;
    }

    public String getiDFacility() {
        return iDFacility;
    }

    public void setiDFacility(String iDFacility) {
        this.iDFacility = iDFacility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(String maxPerson) {
        this.maxPerson = maxPerson;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "iDFacility='" + iDFacility + '\'' +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", cost='" + cost + '\'' +
                ", maxPerson='" + maxPerson + '\'' +
                ", type='" + type + '\'' +
                ',';
    }
}
