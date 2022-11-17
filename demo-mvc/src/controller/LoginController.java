package controller;

import model.LoginModel;
import view.LoginView;

public class LoginController {
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    public void login(){
        while (true) {
            LoginModel user = view.getUserInfo();
            if(LoginService.checkLogin(user)){
                view.showMessage("Đăng nhập thành công");
                break;
            }else {
                view.showMessage("Bạn nhập sai tài khoản hoặc mật khẩu, Vui Lòng nhập lại!!!");
            }
        }
    }


    public LoginView getView() {
        return view;
    }

    public void setView(LoginView view) {
        this.view = view;
    }
}
