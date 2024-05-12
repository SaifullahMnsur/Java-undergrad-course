import java.util.*;

public class Inventory {
    private ArrayList<Item> itemList;
    private static Scanner sc = new Scanner(System.in);

    // Constructors
    public Inventory() {
        itemList = new ArrayList<>();
    }
    public Inventory(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }
    public Inventory(Item... items){
        itemList = new ArrayList<>();
        Collections.addAll(itemList, items);
    }

    // Methods
    public void addItem(String name, String type, double price){
        Item item = this.searchItem(name);
        if( item == null ){
            item = new Item(name, type, price);
            this.itemList.add(item);
            System.out.println("item added");
            this.displayHeadRow();
            this.displaySingleItem(item);
        } else {
            System.out.println("Item already into the inventory!");
        }
        return;
    }

    public void displayHeadRow(){
        System.out.printf("%15s %10s  %-10s %8s%n", "Name", "Type", "Price(BDT)", "Quantity");
        return;
    }
    
    public void displaySingleItem(Item item){
        System.out.printf("%15s %10s  %-8.2f %8d%n", item.getName(), item.getType(), item.getPrice(), item.getQuantity());
        return;
    }    

    public void displayItems(){
        if( itemList.isEmpty() ){
            System.out.println("Empty inventory!");
        } else {
            displayHeadRow();
        }
        for( Item item : itemList ){
            this.displaySingleItem(item);
        }
        return;
    }

    public void catagoryWiseDisplay(String type){
        if( itemList.isEmpty() ){
            System.out.println("Empty inventory of " + type + " type!");
            return;
        } else {
            displayHeadRow();
        }
        boolean itemFound = false;
        for( Item item : itemList ){
            if(item.getType().toLowerCase().contains(type.toLowerCase()) || type.toLowerCase().contains(item.getName().toLowerCase())){
                this.displaySingleItem(item);
                itemFound = true;
            }
        }
        if(!itemFound){
            System.out.println("No item found!");
        }
        return;
    }

    public Item searchItem(String name){
        for (Item item : itemList) {
            if(item.getType().toLowerCase().contains(name.toLowerCase()) || name.toLowerCase().contains(item.getName().toLowerCase())){
                return item;
            }
        }
        return null;
    }

    public void purchaseItem(String name, int quantity){
        Item item = searchItem(name);
        if( item == null ){
            System.out.println("Item not found!");
            return;
        } else {
            int newQuantity = quantity + item.getQuantity();
            item.setQuantity(newQuantity);
            this.displayHeadRow();
            this.displaySingleItem(item);
            System.out.println("Purchased " + name + " at a cost of " + item.getPrice() * quantity + "Tk");
            this.displayHeadRow();
            this.displaySingleItem(item);
            return;
        }
    }

    public void sellItem(String name, int quantity){
        Item item = searchItem(name);
        if( item == null ){
            System.out.println("Item not found!");
            return;
        } else {
            if( item.getQuantity() < quantity ){
                System.out.println("Not enough quantity of this item is available!");
                System.out.println(item.getQuantity() + " Left");
                int choice = 0;
                do {
                    System.out.println("Do you want to sell all of them?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    switch (choice) {
                        case 1:
                            System.out.println(item.getQuantity() + " quantity of " + item.getName() + " sold for a price: " + item.getQuantity()*item.getPrice() + " Tk");
                            item.setQuantity(0);
                            return;
                        case 2:
                            System.out.println(item.getName() + " not sold!");
                            return;
                        default:
                            System.out.println("Wrong input! try again!");
                            break;
                    }
                } while (choice != 1 || choice != 2);
            } else {
                System.out.println(quantity + " quantity of " + item.getName() + " sold for a price: " + quantity*item.getPrice() + "Tk");
                int newQuantity = item.getQuantity() - quantity;
                item.setQuantity(newQuantity);
                return;
            }
        }
    }
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        int choice = 0;
        String name, type;
        double price;
        Item item = null;
        int quantity;
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
                    // Case to add new item in the inventory
                    System.out.println("..ADD NEW ITEM...");
                    System.out.print("Enter name: ");
                    name = sc.nextLine();
                    System.out.print("Enter type: ");
                    type = sc.next();
                    sc.nextLine();
                    System.out.print("Enter price: ");
                    price = sc.nextDouble();
                    sc.nextLine();
                    inventory.addItem(name, type, price);
                    break;

                case 2:
                    // case to purchase item
                    System.out.println("...PURCHASE ITEM...");
                    System.out.print("Enter name: ");
                    name = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    inventory.purchaseItem(name, quantity);
                    break;

                case 3:
                    // case to sell item
                    System.out.println("...SELL ITEM...");
                    System.out.print("Enter name: ");
                    name = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt();
                    inventory.sellItem(name, quantity);
                    break;
                    
                case 4:
                    // case to display all items in the inventory
                    System.out.println("...DISPLAY ALL ITEM...");
                    inventory.displayItems();
                    break;

                case 5:
                    // case to catagory wise display items
                    System.out.println("...CATAGORYWISE DISPLAY...");
                    System.out.print("Enter type: ");
                    type = sc.next();
                    sc.nextLine();
                    inventory.catagoryWiseDisplay(type);
                    break;

                case 6:
                    // case to search item by name
                    System.out.println("...SEARCH ITEM...");
                    System.out.print("Enter name: ");
                    name = sc.nextLine();
                    item = inventory.searchItem(name);

                    if( item == null ){
                        System.out.println("Item not found!");
                    } else if( item.getQuantity() == 0 ){
                        System.out.println("Item found! But no quantity available!");
                    } else {
                        System.out.println();
                    }

                    break;

                case 7:
                    // case to exit
                    System.out.print("Exiting");
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
        System.out.println("Program ended successfully");
        return;
    }
}