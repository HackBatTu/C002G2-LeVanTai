package view;

import model.LoginModel;

import java.util.Scanner;

public class LoginView {
    private static Scanner sc = new Scanner(System.in);

    public void showMessage(String smg) {
        System.out.println(smg);
    }
    public LoginModel getUserInfo(){
        LoginModel user = new LoginModel();
        System.out.print("Input Username : ");
        user.setUserName(sc.nextLine());
        System.out.print("Input Password : ");
        user.setPassword(sc.nextLine());
        return user;
    }
}
