/*
 * Created by JFormDesigner on Mon Jun 19 20:15:25 CEST 2017
 */

package Cartelera;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Maingol Dulorres
 */
public class NewDirector extends JFrame {
    final private Connection co = UI.connection();

    public NewDirector() {
        initComponents();
    }

    private void btnConfirmarActionPerformed(ActionEvent e) {
        try {
            Statement stm = co.createStatement();
            //FileWriter fw = new FileWriter("/home/mingle/Downloads/Telegram Desktop/carga_directores.txt",true);
            FileWriter fw = new FileWriter("/home/carlos/Documents/FP/Base de Datos/Cartelera/carga_directores.txt",true);

            String query = " INSERT INTO cartelera.directores (dir_id,dir_nom,dir_ape,dir_fnac,dir_nac,dir_osc,dir_goy)"
                    + " VALUES (?,?,?,?,?,?,?)";

            String idDirector = tfID.getText();
            String nomDirector = tfNombre.getText();
            String apeDirector = tfApellidos.getText();
            String fnDirector = tfFnac.getText();
            String nacDirector = tfNacionalidad.getText();
            String oscDirector = tfOscars.getText();
            String goyDirector = tfGoyas.getText();

            PreparedStatement pstm = co.prepareStatement(query);
            pstm.setInt(1,Integer.parseInt(idDirector));
            pstm.setString(2,nomDirector);
            pstm.setString(3,apeDirector);
            pstm.setString(4,fnDirector);
            pstm.setString(5,nacDirector);
            pstm.setInt(6,Integer.parseInt(oscDirector));
            pstm.setInt(7,Integer.parseInt(goyDirector));

            pstm.execute();

            fw.write(idDirector + ";" + nomDirector + ";" + apeDirector + ";" + fnDirector + ";" + nacDirector + ";" + oscDirector + ";" + goyDirector + ";");

            fw.close();


        } catch (SQLException e2) {
            e2.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        Directores d = new Directores();
        d.setTitle("Directores");
        d.setVisible(true);
        dispose();
    }

    private void btnCancelarActionPerformed(ActionEvent e) {
        Directores d = new Directores();
        d.setVisible(true);
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jaime Leon
        label4 = new JLabel();
        label1 = new JLabel();
        tfID = new JTextField();
        label5 = new JLabel();
        tfFnac = new JTextField();
        label2 = new JLabel();
        tfNombre = new JTextField();
        label6 = new JLabel();
        tfNacionalidad = new JTextField();
        label3 = new JLabel();
        tfApellidos = new JTextField();
        label7 = new JLabel();
        tfOscars = new JTextField();
        label8 = new JLabel();
        tfGoyas = new JTextField();
        btnConfirmar = new JButton();
        btnCancelar = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[118,fill]" +
            "[fill]" +
            "[fill]" +
            "[131,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label4 ----
        label4.setText("INFORMACI\u00d3N DEL DIRECTOR");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD, label4.getFont().getSize() + 3f));
        contentPane.add(label4, "cell 4 1");

        //---- label1 ----
        label1.setText("ID");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));
        contentPane.add(label1, "cell 2 2");

        //---- tfID ----
        tfID.setEditable(false);
        contentPane.add(tfID, "cell 3 2");

        //---- label5 ----
        label5.setText("F. Nacimiento (A-M-D)");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getStyle() | Font.BOLD));
        contentPane.add(label5, "cell 5 2");

        //---- tfFnac ----
        tfFnac.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        contentPane.add(tfFnac, "cell 6 2");

        //---- label2 ----
        label2.setText("Nombre");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD));
        contentPane.add(label2, "cell 2 3");
        contentPane.add(tfNombre, "cell 3 3");

        //---- label6 ----
        label6.setText("Nacionalidad");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getStyle() | Font.BOLD));
        contentPane.add(label6, "cell 5 3");
        contentPane.add(tfNacionalidad, "cell 6 3");

        //---- label3 ----
        label3.setText("Apellido ");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD));
        contentPane.add(label3, "cell 2 4");
        contentPane.add(tfApellidos, "cell 3 4");

        //---- label7 ----
        label7.setText("N\u00ba Oscars");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getStyle() | Font.BOLD));
        contentPane.add(label7, "cell 5 4");
        contentPane.add(tfOscars, "cell 6 4");

        //---- label8 ----
        label8.setText("N\u00ba Goyas");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getStyle() | Font.BOLD));
        contentPane.add(label8, "cell 5 5");

        //---- tfGoyas ----
        tfGoyas.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        contentPane.add(tfGoyas, "cell 6 5");

        //---- btnConfirmar ----
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setFont(btnConfirmar.getFont().deriveFont(btnConfirmar.getFont().getStyle() | Font.BOLD));
        btnConfirmar.addActionListener(e -> {
			btnConfirmarActionPerformed(e);
		});
        contentPane.add(btnConfirmar, "cell 5 6");

        //---- btnCancelar ----
        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(btnCancelar.getFont().deriveFont(btnCancelar.getFont().getStyle() | Font.BOLD));
        btnCancelar.addActionListener(e -> btnCancelarActionPerformed(e));
        contentPane.add(btnCancelar, "cell 6 6");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jaime Leon
    private JLabel label4;
    private JLabel label1;
    private JTextField tfID;
    private JLabel label5;
    private JTextField tfFnac;
    private JLabel label2;
    private JTextField tfNombre;
    private JLabel label6;
    private JTextField tfNacionalidad;
    private JLabel label3;
    private JTextField tfApellidos;
    private JLabel label7;
    private JTextField tfOscars;
    private JLabel label8;
    private JTextField tfGoyas;
    private JButton btnConfirmar;
    private JButton btnCancelar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
