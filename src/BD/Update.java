package BD;

import java.sql.*;

public class Update {
    public static Connection conectar(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/motogp", "root", "");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void actualizarNacionalidad() {
        Connection con = conectar();
        try {
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stm.executeQuery("SELECT * FROM pilotos WHERE pil_pais = 'USA' ");

            while(rs.next()) {
                rs.updateString("pil_pais","Estados Unidos");
                rs.updateRow();
            }

            System.out.println("Actualizado correctamente.");
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        actualizarNacionalidad();
    }
}
