public class Vehicle {
    private String brand, model;
    private int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayVehicleDetails(){
        System.out.println("Brand: " + this.getBrand());
        System.out.println("Model: " + this.getModel());
        System.out.println("Year: " + this.getYear());
    }
}
