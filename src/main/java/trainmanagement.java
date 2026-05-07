import java.sql.*;
import java.util.Scanner;

public class trainmanagement {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/train_system";
        String user = "root";
        String password = "umarsheikh865@";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("✔ Connected Successfully!");

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.println("\n===== TRAIN SYSTEM =====");
                System.out.println("1. Add Passenger");
                System.out.println("2. Book Ticket");
                System.out.println("3. View Tickets");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                // ========================
                // ADD PASSENGER
                // ========================
                if (choice == 1) {

                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    String sql = "INSERT INTO passenger(name, age) VALUES(?,?)";
                    PreparedStatement ps = con.prepareStatement(sql);

                    ps.setString(1, name);
                    ps.setInt(2, age);

                    ps.executeUpdate();
                    System.out.println("✔ Passenger Added!");
                }

                // ========================
                // BOOK TICKET (FIXED)
                // ========================
                else if (choice == 2) {

                    // 🔥 SHOW TRAINS
                    ResultSet rs = con.createStatement().executeQuery("SELECT * FROM train");
                    System.out.println("\nAvailable Trains:");
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
                    }

                    System.out.print("Enter Train ID: ");
                    int trainId = sc.nextInt();

                    // 🔥 SHOW PASSENGERS
                    ResultSet rs2 = con.createStatement().executeQuery("SELECT * FROM passenger");
                    System.out.println("\nAvailable Passengers:");
                    while (rs2.next()) {
                        System.out.println(rs2.getInt("id") + " - " + rs2.getString("name"));
                    }

                    System.out.print("Enter Passenger ID: ");
                    int passengerId = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Seat Number: ");
                    String seat = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    String sql = "INSERT INTO ticket(train_id, passenger_id, seat_number, price) VALUES(?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql);

                    ps.setInt(1, trainId);
                    ps.setInt(2, passengerId);
                    ps.setString(3, seat);
                    ps.setDouble(4, price);

                    ps.executeUpdate();

                    System.out.println("✔ Ticket Booked!");
                }

                // ========================
                // VIEW TICKETS
                // ========================
                else if (choice == 3) {

                    String query =
                        "SELECT t.id, p.name, tr.name, tr.source, tr.destination, t.seat_number, t.price " +
                        "FROM ticket t " +
                        "JOIN passenger p ON t.passenger_id = p.id " +
                        "JOIN train tr ON t.train_id = tr.id";

                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    System.out.println("\n===== TICKET RECORDS =====");

                    while (rs.next()) {
                        System.out.println(
                            rs.getInt(1) + " | " +
                            rs.getString(2) + " | " +
                            rs.getString(3) + " | " +
                            rs.getString(4) + " -> " +
                            rs.getString(5) + " | Seat: " +
                            rs.getString(6) + " | Rs." +
                            rs.getDouble(7)
                        );
                    }
                }

                // ========================
                // EXIT
                // ========================
                else if (choice == 4) {
                    System.out.println("Exiting...");
                    break;
                }

                else {
                    System.out.println("Invalid Choice!");
                }
            }

            con.close();

        } catch (Exception e) {
            System.out.println("❌ ERROR OCCURRED:");
            e.printStackTrace();
        }
    }
}