import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    // Данные из твоего pgAdmin: порт 5433, база car_rental
    private static final String URL = "jdbc:postgresql://localhost:5433/car_rental";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234"; // Тот пароль, который мы установили через ALTER USER

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
