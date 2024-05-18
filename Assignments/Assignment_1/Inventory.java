package src;

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
        itemList.add(item);
    }
    public void displayItems(){
        System.out.printf("%15s %10s  %-10s %n", "Name", "Type", "Price(BDT)");
        for( Item item : itemList ){
            System.out.printf("%15s %10s  %-8.2f %n", item.getName(), item.getType(), item.getPrice());
        }
    }
}
