package ss16_io_text_file.bai_tap.doc_file_csv;

public class Country {
    private Integer id;
    private String code;
    private String name ;

    public Country(Integer ìd, String code, String name) {
        this.id = ìd;
        this.code = code;
        this.name = name;
    }

    public Country() {
    }

    public Integer getÌd() {
        return id;
    }

    public void setÌd(Integer ìd) {
        this.id = ìd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country: [" +
                " id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ']';
    }
}
