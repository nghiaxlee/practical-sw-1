// Le Minh Nghia
//
// AAOGMU
//
// Yogi Bear
//
// 2018/12/10 09:50:32
//
// This solution was submitted and prepared by Le Minh Nghia, AAOGMU for the
// Yogi Bear assignment of the Practical software engineering I. course.
//
// I declare that this solution is my own work.
//
// I have not copied or used third party solutions.
//
// I have not passed my solution to my classmates, neither  made it public.
//
// Students’ regulation of Eötvös Loránd University (ELTE Regulations
// Vol. II. 74/C. § ) states that as long as a student presents another
// student’s work - or at least the significant part of it - as his/her own
// performance, it will count as a disciplinary fault. The most serious
// consequence of a disciplinary fault can be dismissal of the student from
// the University.

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
