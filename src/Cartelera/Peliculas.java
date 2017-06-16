/*
 * Created by JFormDesigner on Thu Jun 15 11:04:22 UTC 2017
 */

package Cartelera;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import net.miginfocom.swing.*;

public class Peliculas extends JFrame {
    final private Connection co = UI.connection();

    public Peliculas() {
        initComponents();

        cargarPeliculas();
        cargarLista();
    }

    class Pelicula {
        String titulo;
        int agno;

        public Pelicula(String titulo, int agno) {
            this.titulo = titulo;
            this.agno = agno;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public int getAgno() {
            return agno;
        }

        public void setAgno(int agno) {
            this.agno = agno;
        }
    }

    private ArrayList<Pelicula> peliculas = new ArrayList<>();

    private void cargarPeliculas() {
        try {
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery("SELECT pel_tit,pel_agno FROM peliculas");

            while(rs.next()) {
                peliculas.add(new Pelicula(rs.getString("pel_tit"),rs.getInt("pel_agno")));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarLista() {
        DefaultListModel<String> model = new DefaultListModel<>();

        for(Pelicula pelicula: peliculas) {
            model.addElement(pelicula.getTitulo() + "," + pelicula.getAgno());
        }
        listaPeliculas.setModel(model);
    }

    private void btnSalirActionPerformed(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jaime Leon
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        listaPeliculas = new JList();
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
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("PELICULAS");
        label1.setFont(new Font("Nimbus Sans", Font.BOLD, 23));
        contentPane.add(label1, "cell 5 0");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(listaPeliculas);
        }
        contentPane.add(scrollPane1, "cell 5 1");

        //---- btnAnadir ----
        btnAnadir.setText("A\u00f1adir");
        btnAnadir.setFont(btnAnadir.getFont().deriveFont(btnAnadir.getFont().getStyle() | Font.BOLD));
        contentPane.add(btnAnadir, "cell 6 2");

        //---- btnBorrar ----
        btnBorrar.setText("Borrar");
        btnBorrar.setFont(btnBorrar.getFont().deriveFont(btnBorrar.getFont().getStyle() | Font.BOLD));
        contentPane.add(btnBorrar, "cell 6 3");

        //---- btnSalir ----
        btnSalir.setText("Volver");
        btnSalir.setFont(btnSalir.getFont().deriveFont(btnSalir.getFont().getStyle() | Font.BOLD));
        btnSalir.addActionListener(e -> btnSalirActionPerformed(e));
        contentPane.add(btnSalir, "cell 6 5");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jaime Leon
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList listaPeliculas;
    private JButton btnAnadir;
    private JButton btnBorrar;
    private JButton btnSalir;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
