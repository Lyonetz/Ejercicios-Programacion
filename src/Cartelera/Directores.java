/*
 * Created by JFormDesigner on Thu Jun 15 11:11:06 UTC 2017
 */

package Cartelera;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import net.miginfocom.swing.*;

public class Directores extends JFrame {
    final private Connection co = UI.connection();

    public Directores() {
        initComponents();

        cargarDirectores();
        cargarLista();
    }

    class Director {
        int id;
        String nombre;
        String apellido;
        String nacionalidad;

        public Director(int id, String nombre, String apellido, String nacionalidad) {
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.nacionalidad = nacionalidad;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getNacionalidad() {
            return nacionalidad;
        }

        public void setNacionalidad(String nacionalidad) {
            this.nacionalidad = nacionalidad;
        }
    }

    private ArrayList<Director> directores = new ArrayList<>();

    private void cargarDirectores() {
        try {
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery("SELECT dir_id,dir_nom,dir_ape,dir_nac FROM directores");

            while(rs.next()) {
                directores.add(new Director(rs.getInt("dir_id"),rs.getString("dir_nom"),rs.getString("dir_ape"),rs.getString("dir_nac")));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarLista() {
        listaDirectores.setModel(null);

        DefaultListModel<String> model = new DefaultListModel<>();

        for(Director director : directores) {
            model.addElement(director.getNombre() + " " + director.getApellido() + "," + director.getNacionalidad());
        }
        listaDirectores.setModel(model);
    }

    private void btnSalirActionPerformed(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jaime Leon
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        listaDirectores = new JList();
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
            "[242,fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[6]" +
            "[]"));

        //---- label1 ----
        label1.setText("DIRECTORES");
        label1.setFont(new Font("Nimbus Sans", Font.BOLD, 23));
        contentPane.add(label1, "cell 4 0");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(listaDirectores);
        }
        contentPane.add(scrollPane1, "cell 4 1");

        //---- btnAnadir ----
        btnAnadir.setText("A\u00f1adir");
        btnAnadir.setFont(btnAnadir.getFont().deriveFont(btnAnadir.getFont().getStyle() | Font.BOLD));
        contentPane.add(btnAnadir, "cell 5 2");

        //---- btnBorrar ----
        btnBorrar.setText("Borrar");
        btnBorrar.setFont(btnBorrar.getFont().deriveFont(btnBorrar.getFont().getStyle() | Font.BOLD));
        contentPane.add(btnBorrar, "cell 5 3");

        //---- btnSalir ----
        btnSalir.setText("Volver");
        btnSalir.setFont(btnSalir.getFont().deriveFont(btnSalir.getFont().getStyle() | Font.BOLD));
        btnSalir.addActionListener(e -> btnSalirActionPerformed(e));
        contentPane.add(btnSalir, "cell 5 5");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jaime Leon
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList listaDirectores;
    private JButton btnAnadir;
    private JButton btnBorrar;
    private JButton btnSalir;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
