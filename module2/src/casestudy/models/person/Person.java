package casestudy.models.person;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private Integer iD;
    private String name;
    private String date;
    private String gender;
    private Integer idCard;
    private String phone;
    private String email;
//    id ,Họ tên, Ngày sinh, Giới tính, Số CMND, Số Điện Thoại, Email,


    public Person(Integer iD, String name, String date, String gender, Integer idCard, String phone, String email) {
        this.iD = iD;
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
    }

    public Person() {
    }

    public Integer getID() {
        return iD;
    }

    public void setId(Integer iD) {
        this.iD = iD;
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

    public String convertLine() {
        String line = this.iD + "," +
                this.name + "," +
                this.date + "," +
                this.gender + "," +
                this.idCard + "," +
                this.phone + "," +
                this.email;
        return line;
    }

    @Override
    public String toString() {
        return "id='" + iD + '\'' +
                        ", name='" + name + '\'' +
                        ", date='" + date + '\'' +
                        ", gender='" + gender + '\'' +
                        ", idCard=" + idCard +
                        ", phone='" + phone + '\'' +
                        ", email='" + email + '\'' +
                        ",";
    }
}
