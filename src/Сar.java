class Car extends Vehicle {

    public Car(int id, String brand, String model) {
        super(id, brand, model);
    }

    @Override
    public String getType() {
        return "Car";
    }
}