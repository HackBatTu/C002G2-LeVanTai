package casestudy.models;

public abstract class Facility {
    private Integer id;
    private String serviceName;
    private Integer area;
    private Integer rentalCosts;
    private Integer maxPerson;
    private String rentalType;

//    Tên dịch vụ, Diện tích sử dụng, Chi phí thuê, Số lượng người tối đa, Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ)

    public Facility() {
    }

    public Facility(Integer id,String serviceName, Integer area, Integer rentalCosts, Integer maxPerson, String rentalType) {
        this.id = id;
        this.serviceName = serviceName;
        this.area = area;
        this.rentalCosts = rentalCosts;
        this.maxPerson = maxPerson;
        this.rentalType = rentalType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "id: "+id+'\''+
                "serviceName: " + serviceName + '\'' +
                ", area: " + area +
                ", rentalCosts: " + rentalCosts +
                ", maxPerson: " + maxPerson +
                ", rentalType: " + rentalType + '\'';
    }
}
