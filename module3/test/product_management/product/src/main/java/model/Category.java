package model;

public class Category {
    private  int id;
    private String name;

    public Category() {
    }

    public Category(int category,String categoryName) {
        this.id = category;
        this.name = categoryName;
    }

    public Category(int category) {
        this.id = category;
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
}
