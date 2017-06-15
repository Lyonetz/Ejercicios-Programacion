/*
 * Created by JFormDesigner on Thu Jun 15 10:46:35 UTC 2017
 */

package Cartelera;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

public class UI extends JFrame {
    public UI() {
        initComponents();
    }

    private void btnPeliculasActionPerformed(ActionEvent e) {
        Peliculas p = new Peliculas();
        p.setVisible(true);
    }

    private void btnActoresActionPerformed(ActionEvent e) {
        Actores a = new Actores();
        a.setVisible(true);
    }

    private void btnDirectoresActionPerformed(ActionEvent e) {
        Directores d = new Directores();
        d.setVisible(true);
    }

    private void btnSalirActionPerformed(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jaime Leon
        label1 = new JLabel();
        btnPeliculas = new JButton();
        btnActores = new JButton();
        btnDirectores = new JButton();
        btnSalir = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
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

        //---- label1 ----
        label1.setText("CARTELERA");
        label1.setFont(new Font("NimbusSans", Font.PLAIN, 23));
        contentPane.add(label1, "cell 3 0");

        //---- btnPeliculas ----
        btnPeliculas.setText("PEL\u00cdCULAS");
        btnPeliculas.setFont(new Font("URW Gothic", Font.BOLD, 13));
        btnPeliculas.addActionListener(e -> btnPeliculasActionPerformed(e));
        contentPane.add(btnPeliculas, "cell 3 2");

        //---- btnActores ----
        btnActores.setText("ACTORES");
        btnActores.setFont(btnActores.getFont().deriveFont(btnActores.getFont().getStyle() | Font.BOLD));
        btnActores.addActionListener(e -> btnActoresActionPerformed(e));
        contentPane.add(btnActores, "cell 3 4");

        //---- btnDirectores ----
        btnDirectores.setText("DIRECTORES");
        btnDirectores.setFont(btnDirectores.getFont().deriveFont(btnDirectores.getFont().getStyle() | Font.BOLD));
        btnDirectores.addActionListener(e -> btnDirectoresActionPerformed(e));
        contentPane.add(btnDirectores, "cell 3 6");

        //---- btnSalir ----
        btnSalir.setText("Salir");
        btnSalir.setFont(btnSalir.getFont().deriveFont(btnSalir.getFont().getStyle() | Font.BOLD));
        btnSalir.addActionListener(e -> btnSalirActionPerformed(e));
        contentPane.add(btnSalir, "cell 5 8");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jaime Leon
    private JLabel label1;
    private JButton btnPeliculas;
    private JButton btnActores;
    private JButton btnDirectores;
    private JButton btnSalir;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
