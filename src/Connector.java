import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    
    public static Connection connect() {

        String url = "jdbc:mysql://localhost:3306/spaceimt";
        String username = "root";
        String password = "";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
