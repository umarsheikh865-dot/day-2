import java.sql.*;
import java.util.Scanner;

// ========================
// DATABASE CONNECTION
// ========================
class DB {
    public static Connection connect() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/train_system",
                "root",
                "your_password"   // change it
            );

            System.out.println("✔ Database Connected");

        } catch (Exception e) {
            System.out.println("❌ Connection Error");
            e.printStackTrace();
        }

        return con;
    }
}

// ========================
// MAIN CLASS
// ========================
public class trainnmanagement {

    // ========================
    // ADD TRAIN
    // ========================
    static void addTrain(Connection con, Scanner sc) {

        try {
            sc.nextLine();

            System.out.print("Train Name: ");
            String name = sc.nextLine();

            System.out.print("Source: ");
            String source = sc.nextLine();

            System.out.print("Destination: ");
            String destination = sc.nextLine();

            String sql = "INSERT INTO train(name, source, destination) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, source);
            ps.setString(3, destination);

            ps.executeUpdate();

            System.out.println("✔ Train Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ========================
    // VIEW TRAINS
    // ========================
    static void viewTrains(Connection con) {

        try {
            String sql = "SELECT * FROM train";

            ResultSet rs = con.createStatement().executeQuery(sql);

            System.out.println("\n--- AVAILABLE TRAINS ---");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("source") + " -> " +
                    rs.getString("destination")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ========================
    // ADD PASSENGER
    // ========================
    static void addPassenger(Connection con, Scanner sc) {

        try {
            sc.nextLine();

            System.out.print("Passenger Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();

            String sql = "INSERT INTO passenger(name, age) VALUES(?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);

            ps.executeUpdate();

            System.out.println("✔ Passenger Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ========================
    // BOOK TICKET (IMPORTANT)
    // ========================
    static void bookTicket(Connection con, Scanner sc) {

        try {
            sc.nextLine();

            // STEP 1: SOURCE & DESTINATION
            System.out.print("Enter Source: ");
            String source = sc.nextLine();

            System.out.print("Enter Destination: ");
            String destination = sc.nextLine();

            // STEP 2: SHOW AVAILABLE TRAINS
            String sql = "SELECT * FROM train WHERE source=? AND destination=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, source);
            ps.setString(2, destination);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- AVAILABLE TRAINS ---");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("source") + " -> " +
                    rs.getString("destination")
                );
            }

            if (!found) {
                System.out.println("❌ No Train Found");
                return;
            }

            // STEP 3: BOOKING INPUT
            System.out.print("\nEnter Train ID: ");
            int trainId = sc.nextInt();

            System.out.print("Enter Passenger ID: ");
            int passengerId = sc.nextInt();

            sc.nextLine();

            System.out.print("Seat Number: ");
            String seat = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            // STEP 4: INSERT TICKET
            String insert = "INSERT INTO ticket(train_id, passenger_id, seat_number, price) VALUES(?,?,?,?)";

            PreparedStatement ps2 = con.prepareStatement(insert);
            ps2.setInt(1, trainId);
            ps2.setInt(2, passengerId);
            ps2.setString(3, seat);
            ps2.setDouble(4, price);

            ps2.executeUpdate();

            System.out.println("✔ Ticket Booked Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ========================
    // VIEW TICKETS
    // ========================
    static void viewTickets(Connection con) {

        try {
            String sql =
                "SELECT t.id, p.name, tr.name, tr.source, tr.destination, t.seat_number, t.price " +
                "FROM ticket t " +
                "JOIN passenger p ON t.passenger_id = p.id " +
                "JOIN train tr ON t.train_id = tr.id";

            ResultSet rs = con.createStatement().executeQuery(sql);

            System.out.println("\n--- ALL TICKETS ---");

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ========================
    // MAIN METHOD
    // ========================
    public static void main(String[] args) {

        Connection con = DB.connect();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== TRAIN MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Train");
            System.out.println("2. View Trains");
            System.out.println("3. Add Passenger");
            System.out.println("4. Book Ticket");
            System.out.println("5. View Tickets");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> addTrain(con, sc);
                case 2 -> viewTrains(con);
                case 3 -> addPassenger(con, sc);
                case 4 -> bookTicket(con, sc);
                case 5 -> viewTickets(con);
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }
}