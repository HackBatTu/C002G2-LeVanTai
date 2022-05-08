package Product.models;

public class Moto extends Transport {
    private String wattage;


    public Moto(String bks, String hangSX, String yearSX, String owner, String wattage) {
        super(bks, hangSX, yearSX, owner);
        this.wattage = wattage;
    }

    public String getWattage() {
        return wattage;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
    }
    public String line(){
        return super.line()+","+ this.wattage;
    }
    @Override
    public String toString() {
        return "Moto [ " + super.toString()+
                " wattage: " + wattage + '\'' +
                ']';
    }
}
