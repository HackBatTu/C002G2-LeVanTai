package bai_tap_lam_them.bai_1_movie;

import java.util.Objects;

public class Movie {
    private String id;
    private String nameMovie;
    private String day;
    private Integer numOfMovie;

    public Movie(String id, String nameMovie, String day, Integer numOfMovie) {
        this.id = id;
        this.nameMovie = nameMovie;
        this.day = day;
        this.numOfMovie = numOfMovie;
    }

    public Movie() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getNumOfMovie() {
        return numOfMovie;
    }

    public void setNumOfMovie(Integer numOfMovie) {
        this.numOfMovie = numOfMovie;
    }
    public String line(){
        return this.id+","+this.nameMovie+","+this.day+","+ this.numOfMovie;
    }
    @Override
    public String toString() {
        return "Movie [" +
                "id: " + id +
                ", nameMovie: " + nameMovie + '\'' +
                ", day: " + day + '\'' +
                ", numOfMovie:" + numOfMovie + '\'' +
                ']';
    }
}
