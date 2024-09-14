package App;

import Controller.CowRegister;
import View.UI;

public class CowRegistrationApp {
    public static void main(String[] args) {
        UI ui = new UI();
        CowRegister controller = new CowRegister(ui);
        controller.startRegistration();
    }
}

