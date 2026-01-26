import java.sql.*;
import java.util.ArrayList;

public class RentService {

    public RentService() {
    }

    public boolean addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (id, brand, model, is_rented, type) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, vehicle.getId());
            pstmt.setString(2, vehicle.getBrand());
            pstmt.setString(3, vehicle.getModel());
            pstmt.setBoolean(4, vehicle.isRented());
            pstmt.setString(5, vehicle.getType());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Vehicle added to database successfully.");
                return true;
            } else {
                System.out.println("Vehicle was NOT added.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error adding vehicle: " + e.getMessage());
            return false;
        }
    }

    public void showAllVehicles() {
        String sql = "SELECT * FROM vehicles";

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- All Vehicles from Database ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Brand: " + rs.getString("brand") +
                        " | Model: " + rs.getString("model") +
                        " | Rented: " + rs.getBoolean("is_rented"));
            }
        } catch (SQLException e) {
            System.out.println("Error showing vehicles: " + e.getMessage());
        }
    }

    public void rentVehicle(int id) {
        String sql = "UPDATE vehicles SET is_rented = true WHERE id = ? AND is_rented = false";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Vehicle rented successfully!");
            } else {
                System.out.println("Vehicle not found or already rented.");
            }
        } catch (SQLException e) {
            System.out.println("Error renting vehicle: " + e.getMessage());
        }
    }

    public void deleteVehicle(int id) {
        String sql = "DELETE FROM vehicles WHERE id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Vehicle deleted from database.");
        } catch (SQLException e) {
            System.out.println("Error deleting vehicle: " + e.getMessage());
        }
    }

    public void showAvailableVehicles() {
        String sql = "SELECT * FROM vehicles WHERE is_rented = false";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Available Vehicles ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Brand: " + rs.getString("brand") + " | Model: " + rs.getString("model"));
            }
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public void returnVehicle(int id) {
        String sql = "UPDATE vehicles SET is_rented = false WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Vehicle returned successfully.");
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public void sortVehiclesById() {
        String sql = "SELECT * FROM vehicles ORDER BY id ASC";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Sorted Vehicles ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | " + rs.getString("brand"));
            }
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public void filterByBrand(String brand) {
        String sql = "SELECT * FROM vehicles WHERE brand ILIKE ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, brand);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("\n--- Filtered by Brand: " + brand + " ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | " + rs.getString("model"));
            }
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }
}
