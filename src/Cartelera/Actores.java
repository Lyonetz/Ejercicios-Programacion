/*
 * Created by JFormDesigner on Thu Jun 15 11:07:45 UTC 2017
 */

package Cartelera;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
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
        String fnac;
        String nac;
        String gen;
        int cache;

        public Actor(int id, String nombre, String apellido, String nacionalidad, String fnac, String nac, String gen, int cache) {
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.nacionalidad = nacionalidad;
            this.fnac = fnac;
            this.nac = nac;
            this.gen = gen;
            this.cache = cache;
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

        public String getFnac() {
            return fnac;
        }

        public void setFnac(String fnac) {
            this.fnac = fnac;
        }

        public String getNac() {
            return nac;
        }

        public void setNac(String nac) {
            this.nac = nac;
        }

        public String getGen() {
            return gen;
        }

        public void setGen(String gen) {
            this.gen = gen;
        }

        public int getCache() {
            return cache;
        }

        public void setCache(int cache) {
            this.cache = cache;
        }
    }

    private static ArrayList<Actor> actores = new ArrayList<>();

    private void cargarActores() {
        try {
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery("SELECT act_id,act_nom,act_ape,act_fnac,act_nac,act_gen,act_cache FROM actores");

            while(rs.next()) {
                Actor a = new Actor(rs.getInt("act_id"),rs.getString("act_nom"),rs.getString("act_ape"),rs.getString("act_nac"),rs.getString("act_fnac"),rs.getString("act_nac"),rs.getString("act_gen"),rs.getInt("act_cache"));
                actores.add(a);
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

        actores.clear();
    }

    private void btnSalirActionPerformed(ActionEvent e) {
        dispose();
    }

    private void btnAnadirActionPerformed(ActionEvent e) {
        NewActor na = new NewActor();

        na.setTitle("Añadir nuevo actor");
        na.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        na.setVisible(true);
        this.dispose();
    }

    private void btnBorrarActionPerformed(ActionEvent e) {
        int seleccion = listaActores.getSelectedIndex();

        try {
            Statement stm = co.createStatement();
            FileWriter fw = new FileWriter("/home/carlos/Documents/FP/Base de Datos/Cartelera/carga_actores.txt",false);

            String query = "DELETE FROM actores WHERE act_id = " + actores.get(seleccion);

            stm.execute(query);

            actores.remove(seleccion);

            for(Actor actor: actores) {
                fw.write(actor.getId() + ";" + actor.getNombre() + ";" + actor.getApellido() + ";" + actor.getFnac() + ";" + actor.getNac() + ";" + actor.getGen() + ";" + actor.getCache() + ";");
            }
            fw.close();

        } catch (SQLException e2) {
            e2.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
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
        btnAnadir.addActionListener(e -> btnAnadirActionPerformed(e));
        contentPane.add(btnAnadir, "cell 7 2");

        //---- btnBorrar ----
        btnBorrar.setText("Borrar");
        btnBorrar.setFont(btnBorrar.getFont().deriveFont(btnBorrar.getFont().getStyle() | Font.BOLD));
        btnBorrar.addActionListener(e -> btnBorrarActionPerformed(e));
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
