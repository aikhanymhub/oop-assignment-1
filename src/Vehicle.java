public abstract class Vehicle {

    protected int id;
    protected String Brand;
    protected String model;
    protected boolean isRented;

    public Vehicle(int id, String brand, String model) {
        this.id = id;
        this.Brand = brand;
        this.model = model;
        this.isRented = false;
    }

    public int getId() {
        return id;
    }

    public boolean isRented() {
        return isRented;
    }

    public String getBrand() {
        return Brand;
    }

    public String getModel() {
        return model;
    }

    public void rent() {
        isRented = true;
    }

    public void giveBack() {
        isRented = false;
    }

    public abstract String getType();

    public void showInfo() {
        System.out.println("Type: " + getType());
        System.out.println("ID: " + id);
        System.out.println("Brand: " + Brand);
        System.out.println("Model: " + model);
        System.out.println("Rented: " + isRented);
        System.out.println("---------------------");
    }
}
