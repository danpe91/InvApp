package invapp.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnector {
    
    public static Connection getMySqlConnection() throws Exception{
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/inventory";
        String username = "root";
        String password = "toor";

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);

        return conn;
    }
}
