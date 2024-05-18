public class Item {
    // properties
    private String name, type;
    private double price;

    // constructors
    public Item(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
    public Item(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = (double) price;
    }

    // getter methods
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public double getPrice(){
        return price;
    }
}
