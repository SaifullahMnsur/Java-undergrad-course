import java.util.ArrayList;

public class Garage {
    private ArrayList<Park> parikingList;
    private int carCap, motorCap, truckCap;
    private int cars, motors, trucks;

    public Garage(int carCap, int motorCap, int truckCap) {
        this.carCap = carCap;
        this.motorCap = motorCap;
        this.truckCap = truckCap;
        parikingList = new ArrayList<>();
        for( int i = 0 ; i < carCap + motorCap + truckCap ; i++ ){
            parikingList.add(new Park(i+1));
        }
    }

    private void privateAddVehicle(Object vehicle){
        Object tempObject = null;
        Park park = null;
        for( int i = 0 ; i < parikingList.size() ; i++ ){
            park = parikingList.get(i);
            tempObject = park.vehicle;
            if( tempObject == null ){
                park.vehicle = vehicle;
                parikingList.set(i, park);
                System.out.println("Parked at: " + park.getSlot());
                return;
            }
        }
    }

    public void addVehicle(Car car) {
        if (cars < carCap) {
            car.displayVehicleDetails();
            this.privateAddVehicle((Object)car);
            cars++;
        } else {
            System.out.println("No more car can be parked!");
        }
    }

    public void addVehicle(Motorcycle motorcycle) {
        if (motors < motorCap) {
            motorcycle.displayVehicleDetails();
            this.privateAddVehicle((Object)motorcycle);
            motors++;
        } else {
            System.out.println("No more Motorcycle can be parked!");
        }
    }

    public void addVehicle(Truck truck) {
        if (trucks < truckCap) {
            truck.displayVehicleDetails();
            this.privateAddVehicle((Object)truck);
            trucks++;
        } else {
            System.out.println("No more Truck can be parked!");
        }
    }

    public void removeVehicle(int slot) {
        if( slot > carCap + motorCap + truckCap ){
            System.out.println("Slot not available!");
            return;
        }
        Object vehicle = parikingList.get(slot-1);
        if( vehicle == null ){
            System.out.println("No vehicle is parked at " + slot );
        } else {
            if( vehicle instanceof Car ){
                System.out.println("Car at " + slot + "Removed!");
                cars--;
            } else if ( vehicle instanceof Motorcycle ){
                System.out.println("Car at " + slot + "Removed!");
                motors--;
            } else if( vehicle instanceof Truck ){
                System.out.println("Car at " + slot + "Removed!");
                trucks--;
            }
            parikingList.set(slot-1, new Park(slot));
        }
    }

    public Object findCheapest() {
        Object minVehicle = null;
        double minPrice = 100000000.0;

        for (Park park : parikingList) {
            Object vehicle = park.vehicle;
            if (vehicle instanceof Car && ((Car) vehicle).getPrice() < minPrice) {
                minPrice = ((Car) vehicle).getPrice();
                minVehicle = vehicle;
            } else if (vehicle instanceof Motorcycle && ((Motorcycle) vehicle).getPrice() < minPrice) {
                minPrice = ((Motorcycle) vehicle).getPrice();
                minVehicle = vehicle;
            } else if (vehicle instanceof Truck && ((Truck) vehicle).getPrice() < minPrice) {
                minPrice = ((Truck) vehicle).getPrice();
                minVehicle = vehicle;
            }
        }


        System.out.println("Cheapest vehicle:");
        if (minVehicle instanceof Car) {
            ((Car) minVehicle).displayVehicleDetails();
        } else if (minVehicle instanceof Motorcycle) {
            ((Motorcycle) minVehicle).displayVehicleDetails();
        } else if (minVehicle instanceof Truck) {
            ((Truck) minVehicle).displayVehicleDetails();
        }
        System.out.println("Cost: " + minPrice);
        return minVehicle;
    }

}

class Park {
    public Object vehicle;
    private int slot;

    public Park(int slot) {
        this.slot = slot;
        this.vehicle = null;
    }
    public int getSlot() {
        return slot;
    }
}
