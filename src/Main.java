import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        if (!Login.authenticate()) {
            System.out.println("Exiting system...");
            return;
        }

        int choice;

        do {
            System.out.println("====== ONLINE RESERVATION SYSTEM ======");
            System.out.println("1. Reservation");
            System.out.println("2. Cancellation");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Reservation.insertReservation();
                    break;

                case 2:
                    Cancellation.cancelTicket();
                    break;

                case 3:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}
