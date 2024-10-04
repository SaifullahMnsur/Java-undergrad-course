public class Car extends Vehicle{
    private String type;
    private boolean hasFrunk, hasTrunk, isElectric;
    private static String vehicleType = "Car";
    private static int wheels = 4;

    public Car(String brand, String model, int year, double price, String type, boolean isElectric, boolean hasFrunk, boolean hasTrunk) {
        super(brand, model, year, price);
        this.type = type;
        this.isElectric = isElectric;
        this.hasFrunk = hasFrunk;
        this.hasTrunk = hasTrunk;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean hasFrunk() {
        return hasFrunk;
    }

    public void setFrunk(boolean hasFrunk) {
        this.hasFrunk = hasFrunk;
    }

    public boolean hasTrunk() {
        return hasTrunk;
    }

    public void setTrunk(boolean hasTrunk) {
        this.hasTrunk = hasTrunk;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean isElectric) {
        this.isElectric = isElectric;
    }

    public int getWheels() {
        return wheels;
    }

    @Override
    public void displayVehicleDetails() {
        System.out.println("Vehicle type: " + Car.vehicleType );
        super.displayVehicleDetails(); // calling super class method
        System.out.println("Type: " + this.getType());
        System.out.println("Electric: " + (this.isElectric()?"Yes":"No") );
        System.out.println("Frunk: " + (this.hasFrunk()?"Yes":"No") );
        System.out.println("Trunk: " + (this.hasTrunk()?"Yes":"No") );
        System.out.println("Wheels: " + this.getWheels() );
    }
    @Override
    public String getVehicleType(){
        return vehicleType;
    }
}
