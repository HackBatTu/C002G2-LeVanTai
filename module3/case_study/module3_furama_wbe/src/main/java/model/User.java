package model;

public class User {
    private String username;
    private String password;
    private int status;

    public User(String username, String password,int status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
