public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", "X7", 2024, "SUV", false, false, true);
        Car car2 = new Car("Tesla", "Model 3", 2023, "Sedan", false, true, true);

        Truck truck1 = new Truck("TATA", "ACE Gold", 2023, 4, 5);
        Truck truck2 = new Truck("Volvo", "FMX 500", 2020, 12, 20);

        Motorcycle motorcycle1 = new Motorcycle("Suzuki", "Hayabusa", 2021, 1340, 150.0);
        Motorcycle motorcycle2 = new Motorcycle("Hero", "Splendor", 2016, 100, 8.5);

        System.out.println("Using method overloading]n");
        // Using method overloading
        displayVehicleDetails(car1);
        displayVehicleDetails(car2);
        
        displayVehicleDetails(truck1);
        displayVehicleDetails(truck2);
        
        displayVehicleDetails(motorcycle1);
        displayVehicleDetails(motorcycle2);
        
        
        System.out.println("Using method overriding of parent class\n");
        // using method overriding of parent class
        car1.displayVehicleDetails();
        car2.displayVehicleDetails();
        
        truck1.displayVehicleDetails();
        truck2.displayVehicleDetails();

        motorcycle1.displayVehicleDetails();
        motorcycle2.displayVehicleDetails();
        
    }
    private static void displayVehicleDetails(Car car){
        System.out.println("Vehicle type: Car");
        System.out.println("Brand: " + car.getBrand());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Type: " + car.getType());
        System.out.println("Electric: " + (car.isElectric()?"Yes":"No") );
        System.out.println("Frunk: " + (car.hasFrunk()?"Yes":"No") );
        System.out.println("Trunk: " + (car.hasTrunk()?"Yes":"No") );
        System.out.println("Tyres: 4");
        System.out.println();
    }
    private static void displayVehicleDetails(Truck truck){
        System.out.println("Vehicle type: Truck");
        System.out.println("Brand: " + truck.getBrand());
        System.out.println("Model: " + truck.getModel());
        System.out.println("Year: " + truck.getYear());
        System.out.println("Load: " +  truck.getLoad() + " Ton");
        System.out.println("Tyre: " +  truck.getTyres());
        System.out.println();
    }
    private static void displayVehicleDetails(Motorcycle motorcycle){
        System.out.println("Vehicle type: Motorcycle");
        System.out.println("Brand: " + motorcycle.getBrand());
        System.out.println("Model: " + motorcycle.getModel());
        System.out.println("Year: " + motorcycle.getYear());
        System.out.println("Engine: " +  motorcycle.getEngineCapacity() + "cc");
        System.out.println("Torque: " +  motorcycle.getTorque() + "Nm");
        System.out.println("Tyres: 2");
        System.out.println();
    }
}