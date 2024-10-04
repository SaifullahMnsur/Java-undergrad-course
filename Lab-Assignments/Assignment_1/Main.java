import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Inventory inventory1 = new Inventory();
        inventory1.addItem(new Item("Sweet Gourd", "Fruit", 35.0));
        inventory1.addItem(new Item("White Pears", "Fruit", 350.0));
        System.out.println();
        inventory1.displayItems();
        System.out.println();

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Peaches", "Fruit", 2795));
        itemList.add(new Item("Tomato", "Vegetable", 70));
        Inventory inventory2 = new Inventory(itemList);
        inventory2.displayItems();
        System.out.println();

        Inventory inventory3 = new Inventory(new Item("Sweet Gourd", "Fruit", 35),
                                             new Item("Peaches", "Fruit", 2795), 
                                             new Item("White Pears", "Fruit", 350), 
                                             new Item("Tomato", "Vegetable", 70));
        inventory3.displayItems();
        System.out.println();
    }

}