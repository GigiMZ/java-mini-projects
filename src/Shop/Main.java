package Shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Project: Shop
        Scanner scn = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Product> sold_products = new ArrayList<>();
        String pin = "1234";
        loop:
        while (true) {
            System.out.println("""
                    Welcome to shop,
                    
                    1) customer services
                    2) company management
                    3) exit""");
            System.out.print("Enter number: ");
            String answer = scn.nextLine();
            switch (answer) {
                case "3":
                    break loop;
                case "2":
                    System.out.print("Please Enter pin: ");
                    String given_pin = scn.nextLine();
                    if (pin.equals(given_pin)) {
                        System.out.println("Correct.");
                        loop1:
                        while (true) {
                            System.out.println("""
                                                                    
                                    1) see shop's stats.
                                    2) add product.
                                    3) exit""");
                            System.out.print("Enter number: ");
                            String input = scn.nextLine();
                            switch (input) {
                                case "3":
                                    break loop1;
                                case "1":
                                    double total_sold = 0;
                                    for (Product product : sold_products) {
                                        total_sold += product.getPrice();
                                    }
                                    System.out.println("money made: "+total_sold);
                                    System.out.println("products left: "+products.size());
                                    break;
                                case "2":
                                    System.out.print("Enter product name: ");
                                    String name = scn.nextLine();
                                    System.out.print("Enter product price: ");
                                    String price = scn.nextLine();
                                    try {
                                        Double.parseDouble(price);
                                    } catch (Exception z) {
                                        System.out.println("Invalid input, try again.\n");
                                        break;
                                    }
                                    Product new_product = new Product(name, Double.parseDouble(price));
                                    products.add(new_product);
                                    System.out.println(name+" has been added to the shop.");
                                default:
                                    System.out.println("Invalid input, try again.");
                            }
                        }
                    } else {
                        System.out.println("Incorrect.");
                    }
                    break;
                case "1":
                    System.out.print("Enter user's balance: ");
                    String balance = scn.nextLine();
                    try {
                        Double.parseDouble(balance);
                    } catch (Exception z) {
                        System.out.println("Invalid input, try again.\n");
                        break;
                    }
                    User user = new User(Double.parseDouble(balance));
                    loop2:
                    while (true) {
                        System.out.println("""
                                1) buy product
                                2) see balance
                                3) exit""");
                        System.out.print("Enter number: ");
                        String input = scn.nextLine();
                        switch (input) {
                            case "1":
                                if (products.isEmpty()) {
                                    System.out.println("There are no products, come back later.\n");
                                    break;
                                }
                                System.out.println("Products:");
                                int i = 1;
                                for (Product product : products) {
                                    System.out.println(i + ") " + product.getName() + ", price: " + product.getPrice());
                                    i++;
                                }
                                System.out.print("\nEnter the product number: ");
                                String sinput = scn.nextLine();
                                try {
                                    int input1 = Integer.parseInt(sinput);
                                    Product selected_product = products.get(input1 - 1);
                                } catch (Exception x) {
                                    System.out.println("Invalid input, try again.\n");
                                    break;
                                }
                                int input1 = Integer.parseInt(sinput);
                                Product selected_product = products.get(input1 - 1);
                                if (selected_product.getPrice() > user.getMoney()) {
                                    System.out.println("Not enough money.");
                                    System.out.println("1) Installment purchase\npress enter to exit");
                                    System.out.print("Enter number: ");
                                    String input2 = scn.nextLine();
                                    if (input2.equals("1")) {
                                        System.out.print("Enter amount of months: ");
                                        String smonth = scn.nextLine();
                                        try {
                                            Integer.parseInt(smonth);
                                        } catch (Exception z) {
                                            System.out.println("Invalid input, try again.\n");
                                            break;
                                        }
                                        int months = Integer.parseInt(smonth);
                                        double installment = user.installment(selected_product, months);
                                        if (user.getMoney() < installment) {
                                            System.out.println("you dont have money for installment.");
                                            break;
                                        }
                                        System.out.println("you will pay "+installment+" every month for "+months+" months.\n");
                                        user.setMoney(user.getMoney()-installment);
                                    }
                                } else {
                                    user.setMoney(user.getMoney() - selected_product.getPrice());
                                    sold_products.add(selected_product);
                                    products.remove(selected_product);
                                    System.out.println("you have bought " + selected_product.getName());
                                    System.out.println("\nYour Balance: " + user.getMoney() + "\n");
                                }
                                break;
                            case "2":
                                System.out.println("Your balance: "+user.getMoney()+"\n");
                                break;
                            case "3":
                                break loop2;
                            default:
                                System.out.println("Invalid input, try again.\n");
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid input, try again.\n");
            }
        }
    }
}
