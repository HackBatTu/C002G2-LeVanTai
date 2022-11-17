import controller.LoginController;
import view.LoginView;

public class EnvironmentConfig {
    public static void main(String[] args) {
        LoginView view = new LoginView();
        LoginController run = new LoginController(view);

        run.login();
    }
}
