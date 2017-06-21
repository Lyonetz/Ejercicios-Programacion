/*
 * Created by JFormDesigner on Tue Jun 20 18:20:27 CEST 2017
 */

package Cartelera;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Maingol Dulorres
 */
public class NewPelicula extends JFrame {
    final private Connection co = UI.connection();

    public NewPelicula() {
        initComponents();
    }

    private void btnConfirmarActionPerformed(ActionEvent e) {
        try {
            Statement stm = co.createStatement();
            FileWriter fw = new FileWriter("/home/mingle/Downloads/Telegram Desktop/carga_peliculas.txt",true);

            String query = " INSERT INTO cartelera.peliculas (pel_tit, pel_agno, pel_dur, pel_gen, pel_dir_id)"
                    + " VALUES (?,?,?,?,?)";

            String titulo = tfTitulo.getText();
            String agno = tfAgno.getText();
            int duracion = Integer.parseInt(tfDur.getText());
            String genero = tfGen.getText();
            int dir = Integer.parseInt(tfIDDir.getText());

            PreparedStatement pstm = co.prepareStatement(query);
            pstm.setString(1, titulo);
            pstm.setString(2, agno);
            pstm.setInt(3, duracion);
            pstm.setString(4, genero);
            pstm.setInt(5, dir);

            pstm.execute();

            fw.write(titulo + ";" + agno + ";" + duracion + ";" + genero + ";" + dir + ";\n");

            fw.close();


        } catch (SQLException e2) {
            e2.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        Peliculas p = new Peliculas();
        p.setTitle("Películas");
        p.setVisible(true);
        p.setLocationRelativeTo(null);
        p.setResizable(false);
        p.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dispose();
    }

    private void btnCancelarActionPerformed(ActionEvent e) {
        Peliculas p = new Peliculas();
        p.setTitle("Películas");
        p.setVisible(true);
        p.setLocationRelativeTo(null);
        p.setResizable(false);
        p.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Maingol Dulorres
        label4 = new JLabel();
        label1 = new JLabel();
        tfTitulo = new JTextField();
        label5 = new JLabel();
        tfGen = new JTextField();
        label2 = new JLabel();
        tfAgno = new JTextField();
        label6 = new JLabel();
        tfIDDir = new JTextField();
        label3 = new JLabel();
        tfDur = new JTextField();
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
            "[150,fill]" +
            "[fill]" +
            "[fill]" +
            "[154,fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label4 ----
        label4.setText("INFORMACI\u00d3N DEL PEL\u00cdCULA");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD, label4.getFont().getSize() + 3f));
        contentPane.add(label4, "cell 4 1");

        //---- label1 ----
        label1.setText("T\u00edtulo");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));
        contentPane.add(label1, "cell 2 2");
        contentPane.add(tfTitulo, "cell 3 2");

        //---- label5 ----
        label5.setText("G\u00e9nero");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getStyle() | Font.BOLD));
        contentPane.add(label5, "cell 5 2");

        //---- tfGen ----
        tfGen.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        contentPane.add(tfGen, "cell 6 2");

        //---- label2 ----
        label2.setText("A\u00f1o");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD));
        contentPane.add(label2, "cell 2 3");
        contentPane.add(tfAgno, "cell 3 3");

        //---- label6 ----
        label6.setText("ID Director");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getStyle() | Font.BOLD));
        contentPane.add(label6, "cell 5 3");
        contentPane.add(tfIDDir, "cell 6 3");

        //---- label3 ----
        label3.setText("Duraci\u00f3n");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD));
        contentPane.add(label3, "cell 2 4");
        contentPane.add(tfDur, "cell 3 4");

        //---- btnConfirmar ----
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setFont(btnConfirmar.getFont().deriveFont(btnConfirmar.getFont().getStyle() | Font.BOLD));
        btnConfirmar.addActionListener(e -> {
			btnConfirmarActionPerformed(e);
		});
        contentPane.add(btnConfirmar, "cell 5 4");

        //---- btnCancelar ----
        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(btnCancelar.getFont().deriveFont(btnCancelar.getFont().getStyle() | Font.BOLD));
        btnCancelar.addActionListener(e -> btnCancelarActionPerformed(e));
        contentPane.add(btnCancelar, "cell 6 4");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Maingol Dulorres
    private JLabel label4;
    private JLabel label1;
    private JTextField tfTitulo;
    private JLabel label5;
    private JTextField tfGen;
    private JLabel label2;
    private JTextField tfAgno;
    private JLabel label6;
    private JTextField tfIDDir;
    private JLabel label3;
    private JTextField tfDur;
    private JButton btnConfirmar;
    private JButton btnCancelar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
