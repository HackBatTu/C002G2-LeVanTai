package casestudy2.model;

public abstract class Person {
    private String id ;
    private String name ;
    private String birthDay;
    private String gender;
    private String idCart;
    private String email;
    private String phone;

    public Person(String id, String name, String birthDay, String gender, String idCart, String email, String phone) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.idCart = idCart;
        this.email = email;
        this.phone = phone;
    }

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return " id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", gender ='" + gender + '\'' +
                ", idCart='" + idCart + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", ";
    }
}
