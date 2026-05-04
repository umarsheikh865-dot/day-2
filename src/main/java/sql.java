import java.sql.Connection;
import java.sql.DriverManager;

public class sql {
    public static void main(String[] args) {
        try {
            // Load the JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver"); 

            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/myshop?useSSL=false&serverTimezone=UTC",
                "root",
                ""   // leave empty if using XAMPP default
            );

            System.out.println("Connected Successfully!");
        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
    }
}