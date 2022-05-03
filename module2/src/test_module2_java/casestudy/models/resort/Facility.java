package test_module2_java.casestudy.models.resort;

import java.io.Serializable;
import java.util.Objects;

public abstract class Facility implements Serializable {
    private String idFacility;
    private String serviceName;
    private Integer area;
    private Integer rentalCosts;
    private Integer maxPerson;
    private String rentalType;

//    Tên dịch vụ, Diện tích sử dụng, Chi phí thuê, Số lượng người tối đa, Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ)

    public Facility() {
    }

    public Facility(String idFacility,String serviceName, Integer area, Integer rentalCosts, Integer maxPerson, String rentalType) {
        this.idFacility = idFacility;
        this.serviceName = serviceName;
        this.area = area;
        this.rentalCosts = rentalCosts;
        this.maxPerson = maxPerson;
        this.rentalType = rentalType;
    }

    public String getId() {
        return idFacility;
    }

    public void setId(String id) {
        this.idFacility = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(Integer rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public Integer getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(Integer maxPerson) {
        this.maxPerson = maxPerson;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String convertLine() {
        String line = this.idFacility + "," + this.serviceName+ ","+ this.area+ "," +this.rentalCosts + "," + this.maxPerson + "," + this.rentalType ;
        return line;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Facility)) return false;
        Facility facility = (Facility) o;
        return Objects.equals(serviceName, facility.serviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName);
    }

    @Override
    public String toString() {
        return  "id: "+idFacility+'\''+
                ", serviceName: " + serviceName + '\'' +
                ", area: " + area +
                ", rentalCosts: " + rentalCosts +
                ", maxPerson: " + maxPerson +
                ", rentalType: " + rentalType +",";
    }
}
