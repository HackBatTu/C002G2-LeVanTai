package ss12_Java_collection_framework.bai_tap;

public class Product implements Comparable<Product>{
    private Integer id = 0;
    private String name = "name";
    private Integer money = 0;

    public Product() {
    }

    public Product(Integer id, String name, Integer money) {
        this.id = id;
        this.name = name;
        this.money = money;
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

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Product [" +
                "id : " + id +
                ", name : " + name + '\'' +
                ", money: " + money +
                ']';
    }

    @Override
    public int compareTo(Product o) {
        return this.getMoney() -o.getMoney();
    }
}
