package main;

import controlador.LoginController;
import vista.LoginView;

public class main {
    public static void main(String[] args) {
        LoginView login = new LoginView();
        new LoginController(login);
        login.setVisible(true);
    }
}
