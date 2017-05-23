package AhorcadoGUI;

import javax.swing.*;

public class Controller {
    public static void main(String[] args) {
        Ahorcado ahorcado = new Ahorcado();

        ahorcado.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ahorcado.setSize(400,300);
        ahorcado.setVisible(true);
    }
}
