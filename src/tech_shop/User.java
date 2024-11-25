package tech_shop;

import java.util.ArrayList;

public class User {
    private final String name;
    private double budget;
    private ArrayList<Parts> cart;

    public User(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public double getBudget() {
        return budget;
    }

    public ArrayList<Parts> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Parts> cart) {
        this.cart = cart;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
