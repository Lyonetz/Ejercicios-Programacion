package Cartelera;

import javax.swing.*;

public class Controller {
    public static void main(String[] args) {
        UI ui = new UI();

        ui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ui.setTitle("Cartelera");
        ui.setSize(250,275);
        ui.setVisible(true);
    }
}