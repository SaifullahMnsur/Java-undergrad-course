public class Truck extends Vehicle{
    private int tyres, load;
    public Truck(String brand, String model, int year, int tyres, int load) {
        super(brand, model, year);
        this.tyres = tyres;
        this.load = load;
    }

    public int getTyres() {
        return tyres;
    }

    public void setTyres(int tyres) {
        this.tyres = tyres;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    @Override
    public void displayVehicleDetails() {
        System.out.println("Vehicle type: Truck");
        super.displayVehicleDetails();
        System.out.println("Load: " +  this.getLoad() + " Ton");
        System.out.println("Tyre: " +  this.getTyres());
        System.out.println();
    }
}
