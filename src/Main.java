import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RentService rentService = new RentService();
        Scanner scanner = new Scanner(System.in);

        // Adding some vehicles
        rentService.addVehicle(new Vehicle(1, "Toyota", "Camry"));
        rentService.addVehicle(new Vehicle(2, "BMW", "X5"));
        rentService.addVehicle(new Vehicle(3, "Hyundai", "Elantra"));

        while (true) {
            System.out.println("1. Show vehicles");
            System.out.println("2. Rent vehicle");
            System.out.println("3. Return vehicle");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                rentService.showAllVehicles();
            }
            else if (choice == 2) {
                System.out.print("Enter vehicle id: ");
                int id = scanner.nextInt();
                rentService.rentVehicle(id);
            }
            else if (choice == 3) {
                System.out.print("Enter vehicle id: ");
                int id = scanner.nextInt();
                rentService.returnVehicle(id);
            }
            else if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }
            else {
                System.out.println("Wrong option.");
            }
        }

        scanner.close();
    }
}