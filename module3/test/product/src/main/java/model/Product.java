package model;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quality;
    private String color;
    private Category category;

    public Product(int id, String name, double price, int quality, String color, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quality = quality;
        this.color = color;
        this.category = category;
    }

    public Product(String name, double price, int quality, String color, Category category) {
        this.name = name;
        this.price = price;
        this.quality = quality;
        this.color = color;
        this.category = category;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
