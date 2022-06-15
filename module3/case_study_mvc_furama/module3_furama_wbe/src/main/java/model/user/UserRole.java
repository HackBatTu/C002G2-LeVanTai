package model.user;

import model.user.Role;
import model.user.User;

public class UserRole {
    private Role role;
    private User userName;
    private int status;

    public UserRole(Role role, User userName,int status) {
        this.role = role;
        this.userName = userName;
        this.status = status;
    }

    public UserRole() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
    }
}
