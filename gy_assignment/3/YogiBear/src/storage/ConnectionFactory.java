package storage;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    private static MysqlConnectionPoolDataSource conn;

    private ConnectionFactory(){}

    public static Connection getConnection()
            throws ClassNotFoundException, SQLException{
        if (conn == null){
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load Driver
            conn = new MysqlConnectionPoolDataSource();
            conn.setServerName("localhost");
            conn.setPort(3306);
            conn.setDatabaseName("yogibear");
            conn.setUser("nghia");
            conn.setPassword("asd123");
        }
        return conn.getPooledConnection().getConnection();
    }
}
