import java.util.*;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add an Item");
            System.out.println("2. Purchase Item");
            System.out.println("3. Sell Item");
            System.out.println("4. Display Item");
            System.out.println("5. Catagory wise display item");
            System.out.println("6. Search Item");
            System.out.println("7. Exit");
            System.out.println();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {   
                case 1:
                    Main.addItem(sc, inventory);
                    break;
                case 2:
                    Main.purchaseItem(sc, inventory);
                    break;
                case 3:
                    Main.sellItem(sc, inventory);
                    break;
                case 4:
                    inventory.displayItems();
                    break;
                case 5:
                    Main.catagoryWiseDisplay(sc, inventory);
                    break;
                case 6:
                    Main.searchItem(sc, inventory);
                    break;
                case 7:
                    for( int i = 0 ; i < 5 ; i++ ){
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {
                            System.out.println(e.getLocalizedMessage());
                        }
                        System.out.print(".");
                    }
                    break;
                default:
                    System.out.println("Incorrect input! try again!");
                    break;
            }
            System.out.println();
        } while (choice != 7);
        sc.close();
        return;
    }

    private static void searchItem(Scanner sc, Inventory inventory) {
        System.out.print("Item name: ");
        String name = sc.nextLine();
        Item item = inventory.searchItem(name);
        if( item == null ){
            System.out.println("Item not found!");
        } else {
            System.out.println("Item found!");
            inventory.displaySingleItem(item);
        }
        return;
    }

    private static void catagoryWiseDisplay(Scanner sc, Inventory inventory) {
        System.out.print("Item catagory: ");
        String catagory = sc.next();
        inventory.catagoryWiseDisplay(catagory);
        return;
    }

    public static void addItem(Scanner sc, Inventory inventory) {
        System.out.print("Item name: ");
        String name = sc.nextLine();
        Item item = inventory.searchItem(name);
        if( item == null ){
            System.out.print("Item type (fruit/vegetable): ");
            String type = sc.next();
            sc.nextLine();
            System.out.print("Item price(with decimal point): ");
            double price = sc.nextDouble();
            sc.nextLine();
            inventory.addItem(new Item(name, type, price));
        } else {
            System.out.println("Item already available!");
            inventory.purchaseItem(name, 1);
        }
        return;
    }

    public static void purchaseItem(Scanner sc, Inventory inventory){
        System.out.print("Item name: ");
        String name = sc.nextLine();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();
        inventory.purchaseItem(name, quantity);
        return;
    }

    public static void sellItem(Scanner sc, Inventory inventory){
        System.out.print("Item name: ");
        String name = sc.nextLine();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();
        inventory.sellItem(name, quantity);
        return;
    }
}