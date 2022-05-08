package Product.models;

public class Oto extends Transport {
    private String seats;
    private String otoType;


    public Oto(String bks, String manufacturer, String yearSX, String owner, String seats, String otoType) {
        super(bks, manufacturer, yearSX, owner);
        this.seats = seats;
        this.otoType = otoType;
    }

    public String getSoGhe() {
        return seats;
    }

    public void setSoGhe(String soGhe) {
        this.seats = soGhe;
    }

    public String getOtoType() {
        return otoType;
    }

    public void setOtoType(String otoType) {
        this.otoType = otoType;
    }
    public String line(){
        return super.line()+","+ this.seats+","+this.otoType;
    }
    @Override
    public String toString() {
        return "Oto [ " + super.toString()+
                " soGhe: " + seats + '\'' +
                ", otoType: " + otoType + '\'' +
                ']';
    }
}
