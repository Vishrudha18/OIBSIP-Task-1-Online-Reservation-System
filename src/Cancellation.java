import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Cancellation {

    public static void cancelTicket() {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DBConnection.getConnection();
            if (con == null) {
                System.out.println("Database connection error.");
                return;
            }

            System.out.print("Enter PNR Number: ");
            int pnr = sc.nextInt();
            sc.nextLine();

            String fetchQuery = "SELECT * FROM reservations WHERE pnr = ?";
            PreparedStatement fetchPs = con.prepareStatement(fetchQuery);
            fetchPs.setInt(1, pnr);

            ResultSet rs = fetchPs.executeQuery();

            if (!rs.next()) {
                System.out.println("No reservation found for given PNR.");
                return;
            }

            System.out.println("\n--- Ticket Details ---");
            System.out.println("Passenger Name: " + rs.getString("name"));
            System.out.println("Train Number: " + rs.getString("train_number"));
            System.out.println("Train Name: " + rs.getString("train_name"));
            System.out.println("Class Type: " + rs.getString("class_type"));
            System.out.println("Journey Date: " + rs.getDate("journey_date"));
            System.out.println("From: " + rs.getString("source"));
            System.out.println("To: " + rs.getString("destination"));

            System.out.print("\nConfirm Cancellation (Y/N): ");
            String confirm = sc.nextLine();

            if (confirm.equalsIgnoreCase("Y")) {

                String deleteQuery = "DELETE FROM reservations WHERE pnr = ?";
                PreparedStatement deletePs = con.prepareStatement(deleteQuery);
                deletePs.setInt(1, pnr);

                deletePs.executeUpdate();
                System.out.println("Ticket Cancelled Successfully!");

            } else {
                System.out.println("Cancellation Aborted.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
