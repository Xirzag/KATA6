package kata6;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;

public class PersonLoader {

    public static ArrayList<Person1> read() throws ClassNotFoundException, SQLException {
        ArrayList<Person1> list = new ArrayList<>();

        Class.forName("org.sqlite.JDBC");
        Connection connect = DriverManager.getConnection("jdbc:sqlite:KATA.sDB");
        Statement state = connect.createStatement();

        ResultSet rs = state.executeQuery("SELECT * FROM PEOPLE");

        while (rs.next()) {
            Integer id = rs.getInt(1);
            String name = rs.getString(2);
            String gender = rs.getString(3);
            String birthdate = rs.getString(4);
            Float weight = rs.getFloat(5);
            String mail = rs.getString(6);
            
            list.add(new Person1(id, name, gender, birthdate, weight, mail));
        }

        return list;
    }
}