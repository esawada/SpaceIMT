package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    
    public static Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/spaceimt";
        String username = "root";
        String password = "eduardo310";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
