import java.util.ArrayList;

public class RentService {

    private ArrayList<Vehicle> vehicles;

    public RentService() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (findVehicleById(vehicle.getId()) != null) {
            System.out.println("Vehicle with this ID already exists.");
            return;
        }
        vehicles.add(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    public void showAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("NO vehicles available.");
            return;
        }
        for (Vehicle vehicle : vehicles) {
            vehicle.showInfo();
        }
    }

    public Vehicle findVehicleById(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) return vehicle;
        }
        return null;
    }

    public void showAvailableVehicles() {
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (!vehicle.isRented()) {
                vehicle.showInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No available vehicles.");
    }

    public void sortVehiclesById() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to sort.");
            return;
        }
        vehicles.sort((v1, v2) -> Integer.compare(v1.getId(), v2.getId()));
        System.out.println("Vehicles sorted by ID.");
    }

    public void rentVehicle(int id) {
        Vehicle vehicle = findVehicleById(id);
        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }
        if (!vehicle.isRented()) {
            vehicle.rent();
            System.out.println("Vehicle rented successfully.");
        } else {
            System.out.println("Vehicle is already rented.");
        }
    }

    public void returnVehicle(int id) {
        Vehicle vehicle = findVehicleById(id);
        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }
        if (vehicle.isRented()) {
            vehicle.giveBack();
            System.out.println("Vehicle returned successfully.");
        } else {
            System.out.println("Vehicle was not rented.");
        }
    }
}
