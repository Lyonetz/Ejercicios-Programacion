/*
 * Created by JFormDesigner on Tue May 16 12:18:30 CEST 2017
 */

package ConvertidorDivisasGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Carlos Javier LeÃ³n
 */
public class ConvertidorMonedas extends JFrame {
    public ConvertidorMonedas() {
        initComponents();
    }

    private void btnEurosDolaresActionPerformed(ActionEvent e) {
        double euros = Double.parseDouble(tfEuros.getText());
        double dolares = euros * 1.1015;

        tfDolares.setText(String.valueOf(dolares));
    }

    private void btnDolaresEurosActionPerformed(ActionEvent e) {
        double dolares = Double.parseDouble(tfDolares.getText());
        double euros = dolares * 0.91;

        tfEuros.setText(String.valueOf(euros));
    }

    private void btnReiniciarActionPerformed(ActionEvent e) {
        tfEuros.setText("");
        tfDolares.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Carlos Javier LeÃ³n
        lEuros = new JLabel();
        tfEuros = new JTextField();
        btnEurosDolares = new JButton();
        lDolares = new JLabel();
        tfDolares = new JTextField();
        btnDolaresEuros = new JButton();
        btnReiniciar = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[69,fill]" +
            "[71,fill]" +
            "[52,fill]" +
            "[99,fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- lEuros ----
        lEuros.setText("Euros");
        contentPane.add(lEuros, "cell 0 1");

        //---- tfEuros ----
        tfEuros.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        contentPane.add(tfEuros, "cell 1 1");

        //---- btnEurosDolares ----
        btnEurosDolares.setText("\u20ac -> $");
        btnEurosDolares.addActionListener(e -> btnEurosDolaresActionPerformed(e));
        contentPane.add(btnEurosDolares, "cell 2 1");

        //---- lDolares ----
        lDolares.setText("D\u00f3lares");
        contentPane.add(lDolares, "cell 0 2");
        contentPane.add(tfDolares, "cell 1 2");

        //---- btnDolaresEuros ----
        btnDolaresEuros.setText("$ -> \u20ac");
        btnDolaresEuros.addActionListener(e -> btnDolaresEurosActionPerformed(e));
        contentPane.add(btnDolaresEuros, "cell 2 2");

        //---- btnReiniciar ----
        btnReiniciar.setText("Reiniciar valores");
        btnReiniciar.addActionListener(e -> btnReiniciarActionPerformed(e));
        contentPane.add(btnReiniciar, "cell 3 5");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Carlos Javier LeÃ³n
    private JLabel lEuros;
    private JTextField tfEuros;
    private JButton btnEurosDolares;
    private JLabel lDolares;
    private JTextField tfDolares;
    private JButton btnDolaresEuros;
    private JButton btnReiniciar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
