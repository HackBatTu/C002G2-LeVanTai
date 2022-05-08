package Product.models;


public class Truck extends Transport {
    private String tonnage;

    public Truck() {
    }

    public Truck(String bks, String hangSX, String yearSX, String owner, String tonnage) {
        super(bks, hangSX, yearSX, owner);
        this.tonnage = tonnage;
    }

    public String getTonnage() {
        return tonnage;
    }

    public void setTonnage(String tonnage) {
        this.tonnage = tonnage;
    }
    public String line(){
        return super.line()+","+ this.tonnage;
    }
    @Override
    public String toString() {
        return "Truck [" + super.toString()+
                " tonnage: " + tonnage + '\'' +
                ']';
    }
}
