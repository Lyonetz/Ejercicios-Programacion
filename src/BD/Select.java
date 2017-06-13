package BD;

import java.sql.*;
import java.util.ArrayList;

public class Select {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/papeleria", "root", "");
            Statement stm = connection.createStatement();

            ResultSet resultSet = stm.executeQuery("select art_num, art_nom from articulos");

            while (resultSet.next()) {
                arrayList.add(resultSet.getString("art_nom"));
                arrayList2.add(resultSet.getInt("art_num"));

            }

            stm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        arrayList.forEach(System.out::println);

        arrayList2.forEach(System.out::println);

    }
}
