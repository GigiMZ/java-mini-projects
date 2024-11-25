package Shop;

public class Product {
    private String Name;
    private double price;

    public Product(String name, double price) {
        Name = name;
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
