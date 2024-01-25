package buitienanh.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	public static Connection getMSSQLConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String dbName = "Lab04JspServletCus";
        String userName = "sa";
        String password = "123456";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://" + hostName + ":1433;databaseName="+dbName;
        // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());  
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }

	    public static void main(String[] args) throws SQLException, ClassNotFoundException  {

	        System.out.println("Get connection ... ");
	        Connection conn = getMSSQLConnection();
	        System.out.println("Get connection " + conn);
	        System.out.println("Done!");
	    }
}