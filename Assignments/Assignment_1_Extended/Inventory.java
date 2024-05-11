import java.util.ArrayList;
import java.util.Collections;

public class Inventory {
    private ArrayList<Item> itemList;

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
    public void addItem(Item item){
        item.setQuantity(1);
        this.itemList.add(item);
    }
    
    public void displaySingleItem(Item item){
        System.out.printf("%15s %10s  %-8.2f %8d%n", item.getName(), item.getType(), item.getPrice(), item.getQuantity());
        return;
    }    

    public void displayItems(){
        if( itemList.isEmpty() ){
            System.out.println("Empty inventory!");
        } else {
            System.out.printf("%15s %10s  %-10s %8s%n", "Name", "Type", "Price(BDT)", "Quantity");
        }
        for( Item item : itemList ){
            this.displaySingleItem(item);
        }
        return;
    }

    public void catagoryWiseDisplay(String catagory){
        if( itemList.isEmpty() ){
            System.out.println("Empty inventory of this catagory!");
        } else {
            System.out.printf("%15s %10s  %-10s %8s%n", "Name", "Type", "Price(BDT)", "Quantity");
        }
        boolean itemFound = false;
        for( Item item : itemList ){
            if(item.getType().toLowerCase().contains(catagory.toLowerCase()) || catagory.toLowerCase().contains(item.getName().toLowerCase())){
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
        item.addQuantity(quantity);
        System.out.println("Item purchased!");
        displaySingleItem(item);
        return;
    }

    public void sellItem(String name, int quantity){
        Item item = searchItem(name);
        if( item != null ){
            if( item.getQuantity() >= quantity ){
                item.reduceQuantity(quantity);
                System.out.println("Updated!");
                displaySingleItem(item);
                if( item.getQuantity() <= 0 ){
                    this.itemList.remove(item);
                    System.out.println("Item quantity is 0! so item deleted!");
                }
            } else {
                System.out.println("Not enough quantity!");
            }
        } else {
            System.out.println("Item not found!");
        }
        return;
    }
}
