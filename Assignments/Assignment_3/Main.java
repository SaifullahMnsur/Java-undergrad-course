public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", "X7", 2024, 34449.99, "SUV", false, false, true);
        Car car2 = new Car("Tesla", "Model 3", 2023, 34449.99,"Sedan", true, true, true);

        Truck truck1 = new Truck("TATA", "ACE Gold", 2023, 74449.99,4, 5);
        Truck truck2 = new Truck("Volvo", "FMX 500", 2020, 44449.99,12, 20);

        Motorcycle motorcycle1 = new Motorcycle("Suzuki", "Hayabusa", 2021, 14449.99, 1340, 150.0);
        Motorcycle motorcycle2 = new Motorcycle("Hero", "Splendor", 2016, 4449.99, 100, 8.5);

        // System.out.println("Using method overloading\n");
        // // Using method overloading
        // displayVehicleDetails(car1);
        // displayVehicleDetails(car2);
        
        // displayVehicleDetails(truck1);
        // displayVehicleDetails(truck2);
        
        // displayVehicleDetails(motorcycle1);
        // displayVehicleDetails(motorcycle2);
        
        
        System.out.println("Using method overriding of parent class\n");
        // using method overriding of parent class
        car1.displayVehicleDetails();
        car2.displayVehicleDetails();
        
        truck1.displayVehicleDetails();
        truck2.displayVehicleDetails();

        motorcycle1.displayVehicleDetails();
        motorcycle2.displayVehicleDetails();

        System.out.println("\nOpening gararge\n");
        Garage garage = new Garage(2, 2, 2);

        garage.addVehicle(car1);
        System.out.println();
        garage.addVehicle(truck1);
        System.out.println();
        garage.addVehicle(motorcycle2);
        System.out.println();
        garage.findCheapest();     
        
        garage.removeVehicle(3);
        System.out.println();
        garage.removeVehicle(3);
        System.out.println();
        garage.addVehicle(truck2);
        System.out.println();
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
        System.out.println("Tyres: " + car.getWheels());
        System.out.println();
    }
    private static void displayVehicleDetails(Truck truck){
        System.out.println("Vehicle type: Truck");
        System.out.println("Brand: " + truck.getBrand());
        System.out.println("Model: " + truck.getModel());
        System.out.println("Year: " + truck.getYear());
        System.out.println("Load: " +  truck.getLoad() + " Ton");
        System.out.println("Tyre: " +  truck.getWheels());
        System.out.println();
    }
    private static void displayVehicleDetails(Motorcycle motorcycle){
        System.out.println("Vehicle type: Motorcycle");
        System.out.println("Brand: " + motorcycle.getBrand());
        System.out.println("Model: " + motorcycle.getModel());
        System.out.println("Year: " + motorcycle.getYear());
        System.out.println("Engine: " +  motorcycle.getEngineCapacity() + "cc");
        System.out.println("Torque: " +  motorcycle.getTorque() + "Nm");
        System.out.println("Tyres: " + motorcycle.getWheels() );
        System.out.println();
    }
}