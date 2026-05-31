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
                System.out.println("2. Book Ticket (Economy/Business)");
                System.out.println("3. View Tickets");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

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

                else if (choice == 2) {
                    // 1. SELECT TRAIN
                    ResultSet rs = con.createStatement().executeQuery("SELECT * FROM train");
                    System.out.println("\nAvailable Trains:");
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
                    }
                    System.out.print("Enter Train ID: ");
                    int trainId = sc.nextInt();

                    // 2. SHOW AVAILABLE SEATS WITH CLASS AND PRICE
                    System.out.println("\nAvailable Seats:");
                    System.out.println("ID | Seat No | Class    | Price");
                    System.out.println("--------------------------------");
                    String seatSql = "SELECT id, seat_number, class_type, price FROM seats WHERE train_id = ? AND is_booked = FALSE";
                    PreparedStatement psSeat = con.prepareStatement(seatSql);
                    psSeat.setInt(1, trainId);
                    ResultSet rsSeats = psSeat.executeQuery();
                    
                    boolean hasSeats = false;
                    while (rsSeats.next()) {
                        System.out.printf("%-2d | %-7s | %-8s | Rs.%.2f\n", 
                            rsSeats.getInt("id"), 
                            rsSeats.getString("seat_number"), 
                            rsSeats.getString("class_type"), 
                            rsSeats.getDouble("price"));
                        hasSeats = true;
                    }

                    if (!hasSeats) {
                        System.out.println("❌ No available seats for this train!");
                        continue;
                    }

                    System.out.print("\nEnter Seat ID to book: ");
                    int seatId = sc.nextInt();

                    // 3. RETRIEVE CHOSEN SEAT DETAILS
                    PreparedStatement psDetails = con.prepareStatement("SELECT seat_number, price FROM seats WHERE id = ?");
                    psDetails.setInt(1, seatId);
                    ResultSet rsDet = psDetails.executeQuery();
                    rsDet.next();
                    String selectedSeatNum = rsDet.getString("seat_number");
                    double selectedPrice = rsDet.getDouble("price");

                    // 4. SELECT PASSENGER
                    ResultSet rsPass = con.createStatement().executeQuery("SELECT * FROM passenger");
                    System.out.println("\nAvailable Passengers:");
                    while (rsPass.next()) {
                        System.out.println(rsPass.getInt("id") + " - " + rsPass.getString("name"));
                    }
                    System.out.print("Enter Passenger ID: ");
                    int passengerId = sc.nextInt();

                    // 5. BOOK TICKET
                    String sqlTicket = "INSERT INTO ticket(train_id, passenger_id, seat_number, price) VALUES(?,?,?,?)";
                    PreparedStatement psTicket = con.prepareStatement(sqlTicket);
                    psTicket.setInt(1, trainId);
                    psTicket.setInt(2, passengerId);
                    psTicket.setString(3, selectedSeatNum);
                    psTicket.setDouble(4, selectedPrice);
                    psTicket.executeUpdate();

                    // 6. UPDATE SEAT TO BOOKED
                    PreparedStatement psUpdate = con.prepareStatement("UPDATE seats SET is_booked = TRUE WHERE id = ?");
                    psUpdate.setInt(1, seatId);
                    psUpdate.executeUpdate();

                    System.out.println("✔ Ticket Booked!");
                    System.out.println("Details: Seat " + selectedSeatNum + " | Final Price: Rs." + selectedPrice);
                } 

                else if (choice == 3) {
                    String query =
                        "SELECT t.id, p.name, tr.name, tr.source, tr.destination, t.seat_number, t.price " +
                        "FROM ticket t " +
                        "JOIN passenger p ON t.passenger_id = p.id " +
                        "JOIN train tr ON t.train_id = tr.id";

                    ResultSet rs = con.createStatement().executeQuery(query);
                    System.out.println("\n===== TICKET RECORDS =====");
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + 
                                           " | " + rs.getString(4) + " -> " + rs.getString(5) + 
                                           " | Seat: " + rs.getString(6) + " | Rs." + rs.getDouble(7));
                    }
                } 

                else if (choice == 4) {
                    System.out.println("Exiting...");
                    break;
                }
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}