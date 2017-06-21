/*
 * Created by JFormDesigner on Thu Jun 15 11:04:22 UTC 2017
 */

package Cartelera;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import net.miginfocom.swing.*;

public class Peliculas extends JFrame {
    final private Connection co = UI.connection();

    public Peliculas() {
        initComponents();
        btnBorrar.setEnabled(false);
        cargarPeliculas();
        cargarLista();
    }

    class Pelicula {
        String titulo;
        String agno;
        int duracion;
        String genero;
        int director;

        public Pelicula(String titulo, String agno, int duracion, String genero, int director) {
            this.titulo = titulo;
            this.agno = agno;
            this.duracion = duracion;
            this.genero = genero;
            this.director = director;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAgno() {
            return agno;
        }

        public void setAgno(String agno) {
            this.agno = agno;
        }

        public int getDuracion() {
            return duracion;
        }

        public void setDuracion(int duracion) {
            this.duracion = duracion;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public int getDirector() {
            return director;
        }

        public void setDirector(int director) {
            this.director = director;
        }
    }

    private ArrayList<Pelicula> peliculas = new ArrayList<>();

    private void cargarPeliculas() {
        peliculas.clear();
        try {
            Statement stm = co.createStatement();
            ResultSet rs = stm.executeQuery("SELECT pel_tit, pel_agno, pel_dur, pel_gen, pel_dir_id FROM peliculas");

            while(rs.next()) {
                peliculas.add(new Pelicula(rs.getString("pel_tit"),rs.getString("pel_agno"),rs.getInt("pel_dur"), rs.getString("pel_gen"), rs.getInt("pel_dir_id")));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarLista() {
        DefaultListModel<String> model = new DefaultListModel<>();

        for(Pelicula pelicula: peliculas) {
            String formatedYear[] = pelicula.getAgno().split("-");
            model.addElement(pelicula.getTitulo() + ", " + formatedYear[0]);
        }
        listaPeliculas.setModel(model);
    }

    private void btnSalirActionPerformed(ActionEvent e) {
        dispose();
    }

    private void btnBorrarActionPerformed(ActionEvent e) {
        int seleccion = listaPeliculas.getSelectedIndex();

        try {
            Statement stm = co.createStatement();
            //FileWriter fw = new FileWriter("/home/mingle/Downloads/Telegram Desktop/carga_peliculas.txt",false);
            FileWriter fw = new FileWriter("/home/carlos/Documents/FP/Base de Datos/Cartelera/carga_peliculas.txt",false);

            String query = "DELETE FROM peliculas WHERE pel_tit = '" + peliculas.get(seleccion).getTitulo() + "' AND pel_agno = '" + peliculas.get(seleccion).getAgno() + "'";

            stm.execute(query);

            peliculas.remove(seleccion);

            for(Pelicula pelicula : peliculas) {
                fw.write(pelicula.getTitulo() + ";" + pelicula.getAgno() + ";" + pelicula.getDuracion() + ";" + pelicula.getGenero() + ";" + pelicula.getDirector() + ";\n" );
            }
            fw.close();

        } catch (SQLException e2) {
            e2.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        cargarPeliculas();
        cargarLista();
    }

    private void btnAnadirActionPerformed(ActionEvent e) {
        NewPelicula np = new NewPelicula();

        np.setTitle("Añadir nuevo películas");
        np.setVisible(true);
        np.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        np.setResizable(false);
        np.setLocationRelativeTo(null);
        this.dispose();
    }

    private void listaPeliculasValueChanged(ListSelectionEvent e) {
        if (!listaPeliculas.isSelectionEmpty())
            btnBorrar.setEnabled(true);
        else
            btnBorrar.setEnabled(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Maingol Dulorres
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

            //---- listaPeliculas ----
            listaPeliculas.addListSelectionListener(e -> listaPeliculasValueChanged(e));
            scrollPane1.setViewportView(listaPeliculas);
        }
        contentPane.add(scrollPane1, "cell 5 1");

        //---- btnAnadir ----
        btnAnadir.setText("A\u00f1adir");
        btnAnadir.setFont(btnAnadir.getFont().deriveFont(btnAnadir.getFont().getStyle() | Font.BOLD));
        btnAnadir.addActionListener(e -> btnAnadirActionPerformed(e));
        contentPane.add(btnAnadir, "cell 6 2");

        //---- btnBorrar ----
        btnBorrar.setText("Borrar");
        btnBorrar.setFont(btnBorrar.getFont().deriveFont(btnBorrar.getFont().getStyle() | Font.BOLD));
        btnBorrar.addActionListener(e -> btnBorrarActionPerformed(e));
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
    // Generated using JFormDesigner Evaluation license - Maingol Dulorres
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList listaPeliculas;
    private JButton btnAnadir;
    private JButton btnBorrar;
    private JButton btnSalir;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
