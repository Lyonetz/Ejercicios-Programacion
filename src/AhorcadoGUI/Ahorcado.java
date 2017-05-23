/*
 * Created by JFormDesigner on Tue May 23 13:15:56 CEST 2017
 */

package AhorcadoGUI;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Carlos Javier LeÃ³n
 */
public class Ahorcado extends JFrame {
    public Ahorcado() {
        initComponents();
        generarPalabra(almacenarPalabra());
    }

    private void btnNuevaPalabraActionPerformed(ActionEvent e) {
        generarPalabra(almacenarPalabra());
    }

    private void btnProbarActionPerformed(ActionEvent e) {
        String letra = tfLetra.getText();


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Carlos Javier LeÃ³n
        labelPalabra = new JLabel();
        tfLetra = new JTextField();
        btnProbar = new JButton();
        labelLetras = new JLabel();
        label3 = new JLabel();
        labelIntentos = new JLabel();
        label4 = new JLabel();
        btnNuevaPalabra = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[24,fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));
        contentPane.add(labelPalabra, "cell 2 0");
        contentPane.add(tfLetra, "cell 0 5");

        //---- btnProbar ----
        btnProbar.setText("Probar");
        btnProbar.addActionListener(e -> btnProbarActionPerformed(e));
        contentPane.add(btnProbar, "cell 2 5");
        contentPane.add(labelLetras, "cell 1 6");

        //---- label3 ----
        label3.setText("Letras usadas:");
        contentPane.add(label3, "cell 2 6");
        contentPane.add(labelIntentos, "cell 1 7");

        //---- label4 ----
        label4.setText("Intentos restantes");
        contentPane.add(label4, "cell 2 7");

        //---- btnNuevaPalabra ----
        btnNuevaPalabra.setText("NUEVA PALABRA");
        btnNuevaPalabra.addActionListener(e -> btnNuevaPalabraActionPerformed(e));
        contentPane.add(btnNuevaPalabra, "cell 2 8");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private ArrayList<String> almacenarPalabra() {
        ArrayList<String> arrayPalabras = new ArrayList<>();
        String[] vectorPalabras;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("/home/carlos/IdeaProjects/Ejercicios-Programacion/src/AhorcadoGUI/palabras.txt"));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        try{
            vectorPalabras = br.readLine().split(";");

            for(int i = 0; i < vectorPalabras.length; i++) {
                arrayPalabras.add(vectorPalabras[i]);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }

        return arrayPalabras;
    }

    private String generarPalabra(ArrayList<String> arrayList) {
        Random rnd = new Random();
        int indice = rnd.nextInt(arrayList.size());
        String palabra = arrayList.get(indice);
        String ahorcado = "";

        for(int i = 0; i < palabra.length(); i++) {
            ahorcado = ahorcado.concat("_ ");
            labelPalabra.setText(ahorcado);
        }

        return palabra;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Carlos Javier LeÃ³n
    private JLabel labelPalabra;
    private JTextField tfLetra;
    private JButton btnProbar;
    private JLabel labelLetras;
    private JLabel label3;
    private JLabel labelIntentos;
    private JLabel label4;
    private JButton btnNuevaPalabra;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
