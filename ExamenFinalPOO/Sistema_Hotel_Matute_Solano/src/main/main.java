package main;

import controlador.LoginController;
import vista.LoginView;

public class Main {
    public static void main(String[] args) {
        LoginView login = new LoginView();
        new LoginController(login);
        login.setVisible(true);
    }
}
