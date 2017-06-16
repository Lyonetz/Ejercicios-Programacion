/*
 * Created by JFormDesigner on Thu Jun 15 11:07:45 UTC 2017
 */

package Cartelera;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

public class Actores extends JFrame {
    public Actores() {
        initComponents();
    }

    private void btnSalirActionPerformed(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jaime Leon
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        btnAnadir = new JButton();
        btnBorrar = new JButton();
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
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[7]" +
            "[]"));

        //---- label1 ----
        label1.setText("ACTORES");
        label1.setFont(new Font("Nimbus Sans", Font.BOLD, 23));
        contentPane.add(label1, "cell 6 0");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }
        contentPane.add(scrollPane1, "cell 6 1");

        //---- btnAnadir ----
        btnAnadir.setText("A\u00f1adir");
        btnAnadir.setFont(btnAnadir.getFont().deriveFont(btnAnadir.getFont().getStyle() | Font.BOLD));
        contentPane.add(btnAnadir, "cell 7 2");

        //---- btnBorrar ----
        btnBorrar.setText("Borrar");
        btnBorrar.setFont(btnBorrar.getFont().deriveFont(btnBorrar.getFont().getStyle() | Font.BOLD));
        contentPane.add(btnBorrar, "cell 7 3");

        //---- btnSalir ----
        btnSalir.setText("Salir");
        btnSalir.setFont(btnSalir.getFont().deriveFont(btnSalir.getFont().getStyle() | Font.BOLD));
        btnSalir.addActionListener(e -> btnSalirActionPerformed(e));
        contentPane.add(btnSalir, "cell 7 5");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jaime Leon
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton btnAnadir;
    private JButton btnBorrar;
    private JButton btnSalir;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
