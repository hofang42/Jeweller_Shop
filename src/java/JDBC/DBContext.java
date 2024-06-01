package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBContext implements DatabaseInfo{

    public Connection con;

    public DBContext() {
        try {
            // Edit URL , username, password to authenticate with your MS SQL Server
            String url = DBURL;
            String username = USERDB;
            String password = PASSDB;
            Class.forName(DRIVERNAME);
            con = DriverManager.getConnection(url, username, password);
            System.out.println(con);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
}
