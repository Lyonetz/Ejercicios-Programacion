/*
 * Created by JFormDesigner on Fri Jun 16 08:23:31 UTC 2017
 */

package Cartelera;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Jaime Leon
 */
public class NewActor extends JFrame {
    final private Connection co = UI.connection();

    public NewActor() {
        initComponents();
    }

    private void btnConfirmarActionPerformed(ActionEvent e) {

        try {
            Statement stm = co.createStatement();
            FileWriter fw = new FileWriter("/home/carlos/Documents/FP/Base de Datos/Cartelera/carga_actores.txt",true);

            String query = " INSERT INTO actores (act_id,act_nom,act_ape,act_fnac,act_nac,act_gen,act_cache)"
                    + " VALUES (?,?,?,?,?,?,?)";

            String idActor = tfID.getText();
            String nomActor = tfNombre.getText();
            String apeActor = tfApellidos.getText();
            String fnActor = tfFnac.getText();
            String nacActor = tfNacionalidad.getText();
            String genActor = tfGenero.getText();
            String cachActor = tfCache.getText();


            PreparedStatement pstm = co.prepareStatement(query);
            pstm.setInt(1,Integer.parseInt(idActor));
            pstm.setString(2,nomActor);
            pstm.setString(3,apeActor);
            pstm.setString(4,fnActor);
            pstm.setString(5,nacActor);
            pstm.setString(6,genActor);
            pstm.setInt(7,Integer.parseInt(cachActor));

            pstm.execute();

            fw.write(idActor + ";" + nomActor + ";" + apeActor + ";" + fnActor + ";" + nacActor + ";" + genActor + ";" + cachActor + ";");

            fw.close();


        } catch (SQLException e2) {
            e2.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        Actores a = new Actores();
        a.setVisible(true);
        dispose();
    }

    private void btnCancelarActionPerformed(ActionEvent e) {
        Actores a = new Actores();
        a.setVisible(true);
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
        tfGenero = new JTextField();
        label8 = new JLabel();
        tfCache = new JTextField();
        btnConfirmar = new JButton();
        btnCancelar = new JButton();

        try{
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery("SELECT COUNT(*) FROM actores");

            if(rs.next()) {
                int numAct = rs.getInt(1);
                tfID.setText(String.valueOf(numAct));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[118,fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[119,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label4 ----
        label4.setText("INFORMACI\u00d3N DEL ACTOR");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD, label4.getFont().getSize() + 3f));
        contentPane.add(label4, "cell 4 0");

        //---- label1 ----
        label1.setText("ID");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));
        contentPane.add(label1, "cell 0 2");

        //---- tfID ----
        tfID.setEditable(false);
        contentPane.add(tfID, "cell 2 2");

        //---- label5 ----
        label5.setText("F. Nacimiento (A-M-D)");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getStyle() | Font.BOLD));
        contentPane.add(label5, "cell 5 2");

        //---- tfFnac ----
        tfFnac.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        contentPane.add(tfFnac, "cell 7 2");

        //---- label2 ----
        label2.setText("Nombre");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD));
        contentPane.add(label2, "cell 0 3");
        contentPane.add(tfNombre, "cell 2 3");

        //---- label6 ----
        label6.setText("Nacionalidad");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getStyle() | Font.BOLD));
        contentPane.add(label6, "cell 5 3");
        contentPane.add(tfNacionalidad, "cell 7 3");

        //---- label3 ----
        label3.setText("Apellido ");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD));
        contentPane.add(label3, "cell 0 4");
        contentPane.add(tfApellidos, "cell 2 4");

        //---- label7 ----
        label7.setText("G\u00e9nero");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getStyle() | Font.BOLD));
        contentPane.add(label7, "cell 5 4");
        contentPane.add(tfGenero, "cell 7 4");

        //---- label8 ----
        label8.setText("Cach\u00e9");
        label8.setFont(label8.getFont().deriveFont(label8.getFont().getStyle() | Font.BOLD));
        contentPane.add(label8, "cell 5 5");

        //---- tfCache ----
        tfCache.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        contentPane.add(tfCache, "cell 7 5");

        //---- btnConfirmar ----
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setFont(btnConfirmar.getFont().deriveFont(btnConfirmar.getFont().getStyle() | Font.BOLD));
        btnConfirmar.addActionListener(e -> btnConfirmarActionPerformed(e));
        contentPane.add(btnConfirmar, "cell 5 6");

        //---- btnCancelar ----
        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(btnCancelar.getFont().deriveFont(btnCancelar.getFont().getStyle() | Font.BOLD));
        btnCancelar.addActionListener(e -> btnCancelarActionPerformed(e));
        contentPane.add(btnCancelar, "cell 7 6");
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
    private JTextField tfGenero;
    private JLabel label8;
    private JTextField tfCache;
    private JButton btnConfirmar;
    private JButton btnCancelar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
