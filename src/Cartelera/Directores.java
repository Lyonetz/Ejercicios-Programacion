/*
 * Created by JFormDesigner on Thu Jun 15 11:11:06 UTC 2017
 */

package Cartelera;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
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
        String fnac;
        String nacionalidad;
        int osc;
        int goy;

        public Director(int id, String nombre, String apellido, String fnac, String nacionalidad, int osc, int goy) {
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.fnac = fnac;
            this.nacionalidad = nacionalidad;
            this.osc = osc;
            this.goy = goy;
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

        public int getOsc() {
            return osc;
        }

        public void setOsc(int osc) {
            this.osc = osc;
        }

        public int getGoy() {
            return goy;
        }

        public void setGoy(int goy) {
            this.goy = goy;
        }
    }

    private ArrayList<Director> directores = new ArrayList<>();

    private void cargarDirectores() {
        directores.clear();
        try {
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery("SELECT dir_id,dir_nom,dir_ape,dir_fnac,dir_nac,dir_osc,dir_goy FROM directores");

            while(rs.next()) {
                Director d = new Director(rs.getInt("dir_id"),rs.getString("dir_nom"),rs.getString("dir_ape"),rs.getString("dir_fnac"),rs.getString("dir_nac"),rs.getInt("dir_osc"),rs.getInt("dir_goy"));
                directores.add(d);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarLista() {
        DefaultListModel<String> model = new DefaultListModel<>();

        for(Director director : directores) {
            model.addElement(director.getNombre() + " " + director.getApellido() + "," + director.getNacionalidad());
        }
        listaDirectores.setModel(model);
    }

    private void btnSalirActionPerformed(ActionEvent e) {
        dispose();
    }

    private void btnAnadirActionPerformed(ActionEvent e) {
        NewDirector nd = new NewDirector();

        nd.setTitle("Añadir nuevo director");
        nd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        nd.setVisible(true);
        this.dispose();
    }

    private void btnBorrarActionPerformed(ActionEvent e) {
        int seleccion = listaDirectores.getSelectedIndex();

        try {
            Statement stm = co.createStatement();
            //FileWriter fw = new FileWriter("/home/mingle/Downloads/Telegram Desktop/carga_directores.txt",false);
            FileWriter fw = new FileWriter("/home/carlos/Documents/FP/Base de Datos/carga_directores.txt",false);

            if(seleccion == -1) {
                this.setSize(450,300);
                errorMessage.setText("Seleccione el director que desea borrar.");
            } else {
                String query = "DELETE FROM directores WHERE dir_id = " + directores.get(seleccion).getId();

                stm.execute(query);

                directores.remove(seleccion);

                for(Director director: directores) {
                    fw.write(director.getId() + ";" + director.getNombre() + ";" + director.getApellido() + ";" + director.getFnac() + ";" + director.getNacionalidad() + ";" + director.getOsc() + ";" + director.getGoy() + ";\n" );
                }
            }

            fw.close();

        } catch (SQLException e2) {
            e2.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        cargarDirectores();
        cargarLista();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jaime Leon
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        listaDirectores = new JList();
        errorMessage = new JLabel();
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
        contentPane.add(errorMessage, "cell 4 2");

        //---- btnAnadir ----
        btnAnadir.setText("A\u00f1adir");
        btnAnadir.setFont(btnAnadir.getFont().deriveFont(btnAnadir.getFont().getStyle() | Font.BOLD));
        btnAnadir.addActionListener(e -> btnAnadirActionPerformed(e));
        contentPane.add(btnAnadir, "cell 5 2");

        //---- btnBorrar ----
        btnBorrar.setText("Borrar");
        btnBorrar.setFont(btnBorrar.getFont().deriveFont(btnBorrar.getFont().getStyle() | Font.BOLD));
        btnBorrar.addActionListener(e -> btnBorrarActionPerformed(e));
        contentPane.add(btnBorrar, "cell 5 3");

        //---- btnSalir ----
        btnSalir.setText("Volver");
        btnSalir.setFont(btnSalir.getFont().deriveFont(btnSalir.getFont().getStyle() | Font.BOLD));
        btnSalir.addActionListener(e -> {
			btnSalirActionPerformed(e);
			btnSalirActionPerformed(e);
		});
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
    private JLabel errorMessage;
    private JButton btnAnadir;
    private JButton btnBorrar;
    private JButton btnSalir;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
