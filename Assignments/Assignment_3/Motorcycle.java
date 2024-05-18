public class Motorcycle extends Vehicle{
    private int engineCapacity;
    private double torque;
    public Motorcycle(String brand, String model, int year, int engineCapacity, double torque) {
        super(brand, model, year);
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

    @Override
    public void displayVehicleDetails() {
        System.out.println("Vehicle type: Motorcycle");
        super.displayVehicleDetails();
        System.out.println("Engine: " +  this.getEngineCapacity() + "cc");
        System.out.println("Torque: " +  this.getTorque() + "Nm");
        System.out.println("Tyres: 2");
        System.out.println();
    }
}
