public class Motorcycle extends Vehicle{
    private int engineCapacity;
    private double torque;
    private static String vehicleType = "Motorcycle";
    private static int wheels = 2;

    public Motorcycle(String brand, String model, int year, double price, int engineCapacity, double torque) {
        super(brand, model, year, price);
        this.engineCapacity = engineCapacity;
        this.torque = torque;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public double getTorque() {
        return torque;
    }

    public void setTorque(double torque) {
        this.torque = torque;
    }
    public int getWheels() {
        return wheels;
    }

    @Override
    public void displayVehicleDetails() {
        System.out.println("Vehicle type: " + Motorcycle.vehicleType );
        super.displayVehicleDetails(); // calling super class method
        System.out.println("Engine: " +  this.getEngineCapacity() + "cc");
        System.out.println("Torque: " +  this.getTorque() + "Nm");
        System.out.println("Wheels: " + Motorcycle.wheels );
    }
    @Override
    public String getVehicleType(){
        return vehicleType;
    }
}
