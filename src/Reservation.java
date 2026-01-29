import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Reservation {

    public static void insertReservation() {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DBConnection.getConnection();
            if (con == null) {
                System.out.println("Database connection error.");
                return;
            }

            System.out.print("Enter Passenger Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Train Number: ");
            String trainNumber = sc.nextLine();

            String trainName = getTrainName(trainNumber);
            System.out.println("Train Name: " + trainName);

            System.out.print("Enter Class Type: ");
            String classType = sc.nextLine();

            System.out.print("Enter Journey Date (YYYY-MM-DD): ");
            String journeyDate = sc.nextLine();

            System.out.print("From: ");
            String source = sc.nextLine();

            System.out.print("To: ");
            String destination = sc.nextLine();

            String query = "INSERT INTO reservations " +
                    "(name, train_number, train_name, class_type, journey_date, source, destination) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, name);
            ps.setString(2, trainNumber);
            ps.setString(3, trainName);
            ps.setString(4, classType);
            ps.setString(5, journeyDate);
            ps.setString(6, source);
            ps.setString(7, destination);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Reservation Successful!");
                System.out.println("Your PNR Number: " + rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Dummy train name logic
    private static String getTrainName(String trainNumber) {
        if (trainNumber.equals("101")) return "Chennai Express";
        if (trainNumber.equals("102")) return "Bangalore Mail";
        if (trainNumber.equals("103")) return "Mumbai Express";
        return "General Express";
    }
}
