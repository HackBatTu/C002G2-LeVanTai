package model;

public class Product {
    private Integer id;
    private String name;
    private Double prince;
    private String describe;
    private String manufacturer;

    public Product(Integer id, String name, Double prince, String describe, String manufacturer) {
        this.id = id;
        this.name = name;
        this.prince = prince;
        this.describe = describe;
        this.manufacturer = manufacturer;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrince() {
        return prince;
    }

    public void setPrince(Double prince) {
        this.prince = prince;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prince=" + prince +
                ", describe='" + describe + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
