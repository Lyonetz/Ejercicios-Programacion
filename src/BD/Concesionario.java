package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Concesionario {
    public static Connection conectar(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", "");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void crearTablaCoches() {
        Connection co = conectar();

        try {
            Statement stm = co.createStatement();

            String query = ("DROP TABLE IF EXISTS  concesionario.coches;" +
                    "CREATE TABLE concesionario.coches (" +
                    "coch_mat CHAR(8) PRIMARY KEY, " +
                    "coch_mar VARCHAR(40) NOT NULL," +
                    "coch_mod VARCHAR(40) NOT NULL," +
                    "coch_col VARCHAR(40) NOT NULL," +
                    "coch_anio INT NOT NULL," +
                    "coch_prc INT NOT NULL);");

            stm.executeUpdate(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        crearTablaCoches();
    }
}
