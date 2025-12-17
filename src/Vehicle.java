public class Vehicle {

    private int id;
    private String brand;
    private String model;
    private boolean isRented;

    public Vehicle(int id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.isRented = false;
    }

    public int getId() {
        return id;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rent() {
        isRented = true;
    }

    public void giveBack() {
        isRented = false;
    }

    public void showInfo() {
        System.out.println("ID: " + id);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Rented: " + isRented);
        System.out.println("---------------------");
    }
}