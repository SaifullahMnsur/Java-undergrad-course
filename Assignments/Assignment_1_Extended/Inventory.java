import java.util.*;

public class Inventory {

    // The static main method is defined at the end of this code


    // private properties
    private ArrayList<Item> itemList; 
    private static Scanner sc = new Scanner(System.in); // a global scanner to be use in all methods

    // Constructors
    public Inventory() {
        itemList = new ArrayList<>(); // initialise arraylist
    }
    public Inventory(ArrayList<Item> itemList) {
        this.itemList = itemList; // assgin itemlist argument to itemlist variable
    }
    public Inventory(Item... items){
        itemList = new ArrayList<>();
        // if item array is passed as constructor then use addAll to copy all values to array list
        Collections.addAll(itemList, items);
    }

    // Methods
    public void addItem(String name, String type, double price){
        Item item = this.searchItem(name); // search items
        if( item == null ){
            // if item is not available
            item = new Item(name, type, price);
            this.itemList.add(item); //  add item into itemlist

            // print necessary confirmation messages
            System.out.println("item added");
            this.displayHeadRow();
            this.displaySingleItem(item);
        } else {
            // if item is not available print it
            System.out.println("Item already into the inventory!");
        }
        return;
    }

    // show head row of table
    public void displayHeadRow(){
        // format of print head of each columns
        System.out.printf("%15s %10s  %-10s %8s%n", "Name", "Type", "Price(BDT)", "Quantity");
        return;
    }
    
    // Show rows of table
    public void displaySingleItem(Item item){
        // format of print values of item
        System.out.printf("%15s %10s  %-8.2f %8d%n", item.getName(), item.getType(), item.getPrice(), item.getQuantity());
        return;
    }    

    // Show all items in the inventory
    public void displayItems(){
        if( itemList.isEmpty() ){
            // if inventory is empty print it
            System.out.println("Empty inventory!");
        } else {
            // print head row
            displayHeadRow();
        }
        // use for each loop and print all items' values
        for( Item item : itemList ){
            this.displaySingleItem(item); // print only item
        }
        return;
    }

    // Show all item of desired catagory type
    public void catagoryWiseDisplay(String type){
        if( itemList.isEmpty() ){
            // if inventory is empty print it
            System.out.println("Empty inventory of " + type + " type!");
            return;
        } else {
            // if inventory is not empty print head row
            displayHeadRow();
        }
        // print other values
        boolean itemFound = false;
        // compare types using for each loop
        for( Item item : itemList ){
            if(item.getType().toLowerCase().contains(type.toLowerCase()) || type.toLowerCase().contains(item.getName().toLowerCase())){
                this.displaySingleItem(item); // print only this item
                // if item of this type is found
                itemFound = true;
            }
        }
        if(!itemFound){
            // if no item is found of this type
            System.out.println("No item found!");
        }
        return;
    }

    // Search item with given name
    public Item searchItem(String name){
        // use for each loop to search item
        for (Item item : itemList) {
            // compare the names of item and given name
            if(item.getType().toLowerCase().contains(name.toLowerCase()) || name.toLowerCase().contains(item.getName().toLowerCase())){
                // if item is found return it
                return item;
            }
        }
        // if item is not found return null
        return null;
    }

    // Purchase item of given name
    public void purchaseItem(String name, int quantity){
        Item item = searchItem(name); // search the item
        if( item == null ){
            // if item is not avaiable print it
            System.out.println("Item not found!");
            return;
        } else {
            // calculate new quantity and update the item with it
            int newQuantity = quantity + item.getQuantity();
            item.setQuantity(newQuantity);

            // print the cost of purchasing and print updated values
            System.out.println("Purchased " + name + " at a cost of " + item.getPrice() * quantity + "Tk");
            this.displayHeadRow();
            this.displaySingleItem(item);
            return;
        }
    }

    // Sell item of given name
    public void sellItem(String name, int quantity){
        Item item = searchItem(name); // search item
        if( item == null ){
            // if item is not available print it
            System.out.println("Item not found!");
            return;
        } else {
            // item is available in the inventory
            if( item.getQuantity() < quantity ){
                // if not enough quantity is available
                System.out.println("Not enough quantity of this item is available!");
                System.out.println(item.getQuantity() + " Left");
                int choice = 0;
                do {
                    // ask if all quantity would be sold or not
                    System.out.println("Do you want to sell all of them?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    switch (choice) {
                        case 1:
                            // selected yes so sell all of this item and show cost
                            System.out.println(item.getQuantity() + " quantity of " + item.getName() + " sold for a price: " + item.getQuantity()*item.getPrice() + " Tk");
                            item.setQuantity(0);
                            return;
                        case 2:
                            // selected no so sell no item
                            System.out.println(item.getName() + " not sold!");
                            return;
                        default:
                            // for any other input print wrong input
                            System.out.println("Wrong input! try again!");
                            break;
                    }
                } while (choice != 1 || choice != 2);
            } else {
                // if enough of this quantity is available
                System.out.println(quantity + " quantity of " + item.getName() + " sold for a price: " + quantity*item.getPrice() + "Tk");
                int newQuantity = item.getQuantity() - quantity; // calculate new quantity after selling
                item.setQuantity(newQuantity); // update with new quantity
                return;
            }
        }
    }

    // main method
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        // create necessary variables
        int choice = 0;
        String name, type;
        double price;
        Item item = null;
        int quantity;
        do {
            // print options to do
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
                    name = sc.nextLine(); // name input
                    System.out.print("Enter type: ");
                    type = sc.next(); // type input
                    sc.nextLine(); // to ignore next line charecter
                    System.out.print("Enter price: ");
                    price = sc.nextDouble(); // price input as double
                    sc.nextLine(); // ignore next line charecter
                    inventory.addItem(name, type, price); // pass the values to add this item
                    break;

                case 2:
                    // case to purchase item
                    System.out.println("...PURCHASE ITEM...");
                    System.out.print("Enter name: ");
                    name = sc.nextLine(); // name input
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt(); // quantity input
                    inventory.purchaseItem(name, quantity); // pass the values to purchase this item
                    break;

                case 3:
                    // case to sell item
                    System.out.println("...SELL ITEM...");
                    System.out.print("Enter name: ");
                    name = sc.nextLine(); // name input
                    System.out.print("Enter quantity: ");
                    quantity = sc.nextInt(); // quantity input 
                    inventory.sellItem(name, quantity); // pass this values to sell this item
                    break;
                    
                case 4:
                    // case to display all items in the inventory
                    System.out.println("...DISPLAY ALL ITEM...");
                    inventory.displayItems(); // call to display all items
                    break;

                case 5:
                    // case to catagory wise display items
                    System.out.println("...CATAGORYWISE DISPLAY...");
                    System.out.print("Enter type: ");
                    type = sc.next(); // type input
                    sc.nextLine(); // ignore next line charecter
                    inventory.catagoryWiseDisplay(type); // pass type to print items of that type
                    break;

                case 6:
                    // case to search item by name
                    System.out.println("...SEARCH ITEM...");
                    System.out.print("Enter name: ");
                    name = sc.nextLine(); // name input
                    item = inventory.searchItem(name); // search that item in the inventory

                    if( item == null ){
                        // if item is not available print not available
                        System.out.println("Item not found!");
                    } else if( item.getQuantity() == 0 ){
                        // if item is available but quantity is 0 then print it
                        System.out.println("Item found! But no quantity available!");
                    } else {
                        // Print the item name and quantity
                        System.out.println("Item found!");
                        System.out.println(item.getQuantity() + " quantity of " + item.getName() + " is available!");
                    }

                    break;

                case 7:
                    // case to exit
                    System.out.print("Exiting");
                    // print an animation
                    for( int i = 0 ; i < 6 ; i++ ){
                        // sleep 100ms so that next dot can be printed after that
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {
                            System.out.println(e.getLocalizedMessage());
                        }
                        System.out.print(".");
                    }
                    break;
                default:
                    // for any other input print incorrect
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