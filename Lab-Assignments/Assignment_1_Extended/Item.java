public class Item {
    // properties
    private String name, type;
    private double price;
    private int quantity;

    // constructors
    public Item(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = 0;
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
    public int getQuantity(){
        return quantity;
    }

    // setter methods
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
