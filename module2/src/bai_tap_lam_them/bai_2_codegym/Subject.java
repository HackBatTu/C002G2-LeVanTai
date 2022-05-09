package bai_tap_lam_them.bai_2_codegym;

import java.util.Collections;

public class Subject implements Comparable<Subject>{
    private String id;
    private String name;
    private String version;
    private String hard;
    private String hours;

    public Subject() {
    }
    public Subject(String id, String name, String version, String hard, String hours) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.hard = hard;
        this.hours = hours;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHard() {
        return hard;
    }

    public void setHard(String hard) {
        this.hard = hard;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
    public String line(){
        return this.id+","+this.name+","+this.version+","+this.hard+","+this.hours;
    }
    @Override
    public String toString() {
        return "Subject [" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", hard='" + hard + '\'' +
                ", hours='" + hours + '\'' +
                ']';
    }

    @Override
    public int compareTo(Subject o) {
        return this.getHours().compareTo(o.getHours());
    }
}
