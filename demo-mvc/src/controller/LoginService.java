package controller;

import model.LoginModel;

public class LoginService {

    public static boolean checkLogin(LoginModel user){
        if((user.getUserName().equals("c0222g2"))&&(user.getPassword().equals("123456"))){
            return true;
        }
        return false;
    }
}
