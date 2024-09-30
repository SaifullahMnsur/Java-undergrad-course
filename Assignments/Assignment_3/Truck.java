public class Truck extends Vehicle{
    private int wheels, load;
    private static String vehicleType = "Truck";

    public Truck(String brand, String model, int year, double price,  int wheels, int load) {
        super(brand, model, year, price);
        this.wheels = wheels;
        this.load = load;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    @Override
    public void displayVehicleDetails() {
        System.out.println("Vehicle type: " + Truck.vehicleType );
        super.displayVehicleDetails(); // calling super class method
        System.out.println("Load: " +  this.getLoad() + " Ton");
        System.out.println("Wheels: " +  this.getWheels());
    }

    @Override
    public String getVehicleType(){
        return Truck.vehicleType;
    }
}
