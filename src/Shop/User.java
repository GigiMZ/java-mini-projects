package Shop;

public class User {
    private double money;

    public User(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double installment(Product product, int months) {
        return product.getPrice() / months;
    }
}