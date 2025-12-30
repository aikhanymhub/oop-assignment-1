import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RentService rentService = new RentService();
        Scanner scanner = new Scanner(System.in);

        // Adding vehicles
        rentService.addVehicle(new Car(1, "Toyota", "Camry"));
        rentService.addVehicle(new Car(2, "BMW", "X5"));
        rentService.addVehicle(new Car(3, "Hyundai", "Elantra"));

        while (true) {
            System.out.println("\n--- Vehicle Rental System ---");
            System.out.println("1. Show all vehicles");
            System.out.println("2. Show available vehicles");
            System.out.println("3. Rent vehicle");
            System.out.println("4. Return vehicle");
            System.out.println("5. Sort vehicles by ID");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    rentService.showAllVehicles();
                    break;
                case 2:
                    rentService.showAvailableVehicles();
                    break;
                case 3:
                    System.out.print("Enter vehicle id: ");
                    rentService.rentVehicle(scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Enter vehicle id: ");
                    rentService.returnVehicle(scanner.nextInt());
                    break;
                case 5:
                    rentService.sortVehiclesById();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Wrong option.");
            }
        }
    }
}
