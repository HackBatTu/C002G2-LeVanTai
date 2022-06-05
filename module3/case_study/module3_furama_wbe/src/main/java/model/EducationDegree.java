package model;

public class EducationDegree {
    private int id;
    private String name;
    private int status;

    public EducationDegree(int id, String name,int status) {
        this.id = id;
        this.name = name;
        this.status=status;
    }

    public EducationDegree(int education_degree_id) {
        this.id = education_degree_id;
    }
    public EducationDegree(int education_degree_id,String education_degree_name) {
        this.id = education_degree_id;
        this.name = education_degree_name;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
