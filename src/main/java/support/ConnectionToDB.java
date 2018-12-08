package support;

import java.sql.*;

/**
 * Получение коннекта к базе
 */
public class ConnectionToDB {
    /**
     * Коннект к базе
     */
    private static Connection connection;

    private static void createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useUnicode=true";
        connection = DriverManager.getConnection(url,"root","1234");
    }

    public static Connection getConnection() {
        try {
            createConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
