package Product.models;

public abstract class Transport {
    private String bks;
    private String hangSX;
    private String yearSX;
    private String owner;

    public Transport(String bks, String hangSX, String yearSX, String owner) {
        this.bks = bks;
        this.hangSX = hangSX;
        this.yearSX = yearSX;
        this.owner = owner;
    }
    public Transport() {
    }

    public String getBks() {
        return bks;
    }

    public void setBks(String bks) {
        this.bks = bks;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String manufacturer) {
        this.hangSX = manufacturer;
    }

    public String getYearSX() {
        return yearSX;
    }

    public void setYearSX(String yearSX) {
        this.yearSX = yearSX;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    Manufacturer manufacturer = new Manufacturer();
    public String line(){
        return this.bks+","+manufacturer.line()+"," +this.yearSX+","+ this.owner;
    }
    @Override
    public String toString() {
        return " bks : " + bks + '\'' +
                ",Manufacturer: " + hangSX +
                ",yearSX : " + yearSX + '\'' +
                ",Owner : " + owner + '\'' +
                ',';
    }
}
