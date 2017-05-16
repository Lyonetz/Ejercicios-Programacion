/*
 * Created by JFormDesigner on Tue May 16 10:50:42 CEST 2017
 */

package GUI;

import javax.swing.*;
import net.miginfocom.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author unknown
 */
public class ConvertidorEurosDolares extends JFrame {
    public ConvertidorEurosDolares() {initComponents();}

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Carlos Javier LeÃ³n
        ConvertidorChecker = new JPanel();
        lEuros = new JLabel();
        tfEuros = new JTextField();
        btnEurosDolares = new JButton();
        lDolares = new JLabel();
        tfDolares = new JTextField();
        btnDolaresEuros = new JButton();

        btnEurosDolares.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEurosDolaresActionPerformed(e);
            }
        });

        btnDolaresEuros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDolaresEurosActionPerformed(e);
            }
        });

        //======== this ========

        // JFormDesigner evaluation mark
        ConvertidorChecker.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), ConvertidorChecker.getBorder())); ConvertidorChecker.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        ConvertidorChecker.setLayout(null);

        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[55,fill]" +
            "[80,fill]" +
            "[135,fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]"));

        //---- lEuros ----
        lEuros.setText("Euros");
        add(lEuros, "cell 0 0");
        add(tfEuros, "cell 1 0");

        //---- btnEurosDolares ----
        btnEurosDolares.setText("Convertir a d\u00f3lares");
        add(btnEurosDolares, "cell 2 0 2 1");

        //---- lDolares ----
        lDolares.setText("Dolares");
        add(lDolares, "cell 0 1");
        add(tfDolares, "cell 1 1");

        //---- btnDolaresEuros ----
        btnDolaresEuros.setText("Convertir a euros");
        add(btnDolaresEuros, "cell 2 1 2 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Carlos Javier LeÃ³n
    private JPanel ConvertidorChecker;
    private JLabel lEuros;
    private JTextField tfEuros;
    private JButton btnEurosDolares;
    private JLabel lDolares;
    private JTextField tfDolares;
    private JButton btnDolaresEuros;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void btnEurosDolaresActionPerformed (ActionEvent event) {
        double euros = Double.parseDouble(tfEuros.getText());
        double dolares = euros * 1.10135;

        tfDolares.setText(String.valueOf(dolares));

    }

    public void btnDolaresEurosActionPerformed (ActionEvent event) {
        double dolares = Double.parseDouble(tfDolares.getText());
        double euros = dolares * 0.91;

        tfEuros.setText(String.valueOf(euros));

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ConvertidorEurosDolares GUI = new ConvertidorEurosDolares();
                GUI.setVisible(true);
            }
        });
    }
}