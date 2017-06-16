/*
 * Created by JFormDesigner on Thu Jun 15 11:07:45 UTC 2017
 */

package Cartelera;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import net.miginfocom.swing.*;

public class Actores extends JFrame {
    final private Connection co = UI.connection();

    public Actores() {
        initComponents();

        cargarActores();
        cargarLista();
    }

    class Actor {
        int id;
        String nombre;
        String apellido;
        String nacionalidad;

        public Actor(int id, String nombre, String apellido, String nacionalidad) {
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

    private ArrayList<Actor> actores = new ArrayList<>();

    private void cargarActores() {
        try {
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery("SELECT act_id,act_nom,act_ape,act_nac FROM actores");

            while(rs.next()) {
                actores.add(new Actor(rs.getInt("act_id"),rs.getString("act_nom"),rs.getString("act_ape"),rs.getString("act_nac")));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarLista() {
        DefaultListModel<String> model = new DefaultListModel<>();

        for(Actor actor: actores) {
            model.addElement(actor.getNombre() + " " + actor.getApellido() + "," + actor.getNacionalidad());
        }
        listaActores.setModel(model);
    }

    private void btnSalirActionPerformed(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jaime Leon
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        listaActores = new JList();
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
            "[0,fill]" +
            "[203,fill]" +
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
        contentPane.add(label1, "cell 5 0");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(listaActores);
        }
        contentPane.add(scrollPane1, "cell 5 1");

        //---- btnAnadir ----
        btnAnadir.setText("A\u00f1adir");
        btnAnadir.setFont(btnAnadir.getFont().deriveFont(btnAnadir.getFont().getStyle() | Font.BOLD));
        contentPane.add(btnAnadir, "cell 7 2");

        //---- btnBorrar ----
        btnBorrar.setText("Borrar");
        btnBorrar.setFont(btnBorrar.getFont().deriveFont(btnBorrar.getFont().getStyle() | Font.BOLD));
        contentPane.add(btnBorrar, "cell 7 3");

        //---- btnSalir ----
        btnSalir.setText("Volver");
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
    private JList listaActores;
    private JButton btnAnadir;
    private JButton btnBorrar;
    private JButton btnSalir;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
