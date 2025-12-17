import java.util.ArrayList;

public class RentService {

    private ArrayList<Vehicle> vehicles;

    public RentService() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    public void showAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
            return;
        }

        for (Vehicle vehicle : vehicles) {
            vehicle.showInfo();
        }
    }

    public void rentVehicle(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                if (!vehicle.isRented()) {
                    vehicle.rent();
                    System.out.println("Vehicle rented successfully.");
                } else {
                    System.out.println("Vehicle is already rented.");
                }
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    public void returnVehicle(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                if (vehicle.isRented()) {
                    vehicle.giveBack();
                    System.out.println("Vehicle returned successfully.");
                } else {
                    System.out.println("Vehicle was not rented.");
                }
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }
}