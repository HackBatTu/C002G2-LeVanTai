package casestudy.models;

public abstract class Person {
    private String name ;
    private String date;
    private String gender;
    private Integer idCard;
    private String phone;
    private String email;
//    Họ tên, Ngày sinh, Giới tính, Số CMND, Số Điện Thoại, Email,
    public Person(String name, String date, String gender, Integer idCard, String phone, String email) {
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "name: " + name + '\'' +
                ", date: " + date + '\'' +
                ", gender: " + gender + '\'' +
                ", idCard: " + idCard +
                ", phone: " + phone + '\'' +
                ", email: " + email + '\'';
    }
}
