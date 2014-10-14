package invapp.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnector {
    
    public static Connection getMySqlConnection() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/new_database";
        String username = "root";
        String password = "toor";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return conn;
    }
}
