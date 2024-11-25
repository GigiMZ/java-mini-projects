package tech_shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Project: tech shop
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<Parts> available_parts = new ArrayList<>();
        String[] available_category = {"CPU", "motherboard", "RAM","GPU", "SSD", "HDD", "PSU", "case"};
        
        System.out.print("Welcome to tech shop,\n");
        System.out.print("Enter your name: ");
        String name = scn.nextLine();
        System.out.print("Enter your budget: ");
        double budget = scn.nextDouble();
        scn.nextLine();
        User user = new User(name, budget);
        loop:
        while (true) {
            System.out.println("""
                    \n1) personal computer parts/accessories/checkout
                    2) add a part/accessory
                    3) exit
                    """);
            System.out.print("Enter number: ");
            String input = scn.nextLine();
            switch (input) {
                case "1":
                    System.out.println("""
                            \n1) choose parts
                            2) choose accessories
                            3) see cart/remove part from cart
                            4) proceed to checkout
                            5) exit""");
                    System.out.print("Enter number: ");
                    String input1 = scn.nextLine();
                    sw:
                    switch (input1) {
                        case "1":
                            System.out.println("""
                                    \n1) Central Processing Unit
                                    2) Motherboard
                                    3) Random Access Memory
                                    4) Graphics Processing Unit
                                    5) Solid State Drive
                                    6) Hard Disk Drive
                                    7) Power Supply Unit
                                    8) Case
                                    9) exit""");
                            System.out.print("Enter index: ");
                            String input2 = scn.nextLine();
                            String category = null;
                            switch (input2) {
                                case "1":
                                    category = "CPU";
                                    break;
                                case "2":
                                    category = "motherboard";
                                    break;
                                case "3":
                                    category = "RAM";
                                    break;
                                case "4":
                                    category = "GPU";
                                    break;
                                case "5":
                                    category = "SSD";
                                    break;
                                case "6":
                                    category = "HDD";
                                    break;
                                case "7":
                                    category = "PSU";
                                    break;
                                case "8":
                                    category = "case";
                                    break;
                                case "9":
                                    break;
                                default:
                                    System.out.println("Invalid input, try again.\n");
                                    break sw;
                            }
                            if (available_parts.isEmpty()) {
                                System.out.println("there are no "+category+" at the moment.");
                                break;
                            }
                            int i = 1;
                            int f = 0;
                            for (; f<available_parts.size(); f++) {
                                Parts p = available_parts.get(f);
                                if (p.getCategory().equals(category)) {
                                    System.out.println(i+") "+p.getName()+", price - "+p.getPrice());
                                    i++;
                                }
                            }
                            System.out.print("Enter index: ");
                            String index = scn.nextLine();
                            if (Integer.parseInt(index) > f) {
                                System.out.println("Invalid input, try again.");
                                break;
                            }
                            try {
                                Integer.parseInt(index);
                            } catch (Exception z) {
                                System.out.println("Invalid input, try again.");
                                break;
                            }
                            ArrayList<Parts> cart;
                            if (user.getCart() == null) {
                                cart = new ArrayList<>();
                            } else {
                                cart = user.getCart();
                            }
                            cart.add(available_parts.get(Integer.parseInt(index)-1));
                            user.setCart(cart);
                            available_parts.remove(Integer.parseInt(index)-1);
                            System.out.println("part has been added to the cart successfully.\n");
                            break;
                        case "2":
                            boolean is_accessory = false;
                            for (Parts p : available_parts) {
                                if (p.getCategory().equals("accessory")) {
                                    is_accessory = true;
                                    break;
                                }
                            }
                            if (!is_accessory) {
                                System.out.println("there are no accessories at the moment.");
                                break;
                            }
                            int z  = 1;
                            for (Parts p : available_parts) {
                                if (p.getCategory().equals("accessory")) {
                                    System.out.println(z+") "+p.getName()+", price - "+p.getPrice());
                                    z++;
                                }
                            }
                            System.out.print("Enter index: ");
                            String index1 = scn.nextLine();
                            if (Integer.parseInt(index1) > z) {
                                System.out.println("Invalid input, try again.");
                                break;
                            }
                            try {
                                Integer.parseInt(index1);
                            } catch (Exception r) {
                                System.out.println("Invalid input, try again.");
                                break;
                            }
                            ArrayList<Parts> cart1 = user.getCart();
                            cart1.add(available_parts.get(Integer.parseInt(index1)-1));
                            user.setCart(cart1);
                            available_parts.remove(Integer.parseInt(index1)-1);
                            System.out.println("part has been added to the cart successfully.\n");
                            break;
                        case "3":
                            System.out.println("""
                                    1) see cart
                                    2) remove part/accessory from the cart""");
                            System.out.print("Enter number: ");
                            String number = scn.nextLine();
                            if (number.equals("1")) {
                                if (user.getCart() == null) {
                                    System.out.println("you don't have any product in your cart.");
                                    break;
                                } else if (user.getCart().isEmpty()) {
                                    System.out.println("you don't have any product in your cart.");
                                    break;
                                }
                                System.out.println(user.getName() + "'s cart:\n");
                                int e = 1;
                                for (Parts p : user.getCart()) {
                                    System.out.println(e + ") " + p.getName() + ", price - " + p.getPrice());
                                    e++;
                                }
                                double total = 0;
                                for (Parts p : user.getCart()) {
                                    total += p.getPrice();
                                }
                                System.out.println("\nTotal: " + total);

                            } else if (number.equals("2")) {
                                if (user.getCart() == null) {
                                    System.out.println("you don't have any product in your cart.");
                                    break;
                                } else if (user.getCart().isEmpty()) {
                                    System.out.println("you don't have any product in your cart.");
                                    break;
                                }
                                int e = 1;
                                for (Parts p : user.getCart()) {
                                    System.out.println(e + ") " + p.getName() + ", price - " + p.getPrice());
                                    e++;
                                }
                                System.out.print("\nEnter index: ");
                                String index2 = scn.nextLine();
                                try {
                                    Integer.parseInt(index2);
                                } catch (Exception q) {
                                    System.out.println("Invalid input, try again.\n");
                                    break;
                                }
                                if (Integer.parseInt(index2) > e) {
                                    System.out.println("Invalid input, try again.\n");
                                    break;
                                }
                                ArrayList<Parts> users_cart = user.getCart();
                                String temp_name = users_cart.get(Integer.parseInt(index2)-1).getName();
                                users_cart.remove(Integer.parseInt(index2)-1);
                                System.out.println(temp_name+" has been removed from your cart.");
                                user.setCart(users_cart);
                            } else {
                                System.out.println("Invalid input, try again.\n");
                            }
                            break;
                        case "4":
                            if (user.getCart() == null) {
                                System.out.println("you don't have any product in your cart.");
                                break;
                            } else if (user.getCart().isEmpty()) {
                                System.out.println("you don't have any product in your cart.");
                                break;
                            }
                            System.out.println("your cart:\n");
                            int v = 1;
                            for (Parts p : user.getCart()) {
                                System.out.println(v+") "+p.getName()+", price - "+p.getPrice());
                                v++;
                            }
                            System.out.print("do you want to proceed to checkout? (type 'yes' or 'no') : ");
                            String input4 = scn.nextLine();
                            if (input4.equals("yes")) {
                                double total = 0;
                                for (Parts p : user.getCart()) {
                                    total += p.getPrice();
                                }
                                if (user.getBudget() < total) {
                                    System.out.println("budget in not enough.\n");
                                    break;
                                }
                                user.setBudget(user.getBudget()-budget);
                                user.setCart(new ArrayList<>());
                            }
                            break;
                        case "5":
                            break;
                        default:
                            System.out.println("Invalid input, try again.\n");
                    }
                    break;
                case "2":
                    System.out.println("""
                            1) add part
                            2) add accessory
                            3) exit""");
                    System.out.print("Enter number: ");
                    String input3 = scn.nextLine();
                    if (input3.equals("1")) {
                        System.out.print("Enter name: ");
                        String part_name = scn.nextLine();
                        String category;
                        while (true) {
                            System.out.print("""
                                    Enter category,
                                    (CPU, motherboard, RAM, GPU, SSD, HDD, PSU, case) :""");
                            category = scn.nextLine();
                            int i = 0;
                            for (String c : available_category) {
                                if (!category.equals(c)) {
                                    i++;
                                }
                            }
                            if (i == available_category.length) {
                                System.out.println("Invalid category, try again.");
                                continue;
                            }
                            break;
                        }
                        String price;
                        while (true) {
                            System.out.print("Enter part price: ");
                            price = scn.nextLine();
                            try {
                            Double.parseDouble(price);
                            } catch (Exception x) {
                                System.out.println("Invalid price, try again.\n");
                                continue;
                            }
                            break;
                        }
                        Parts part = new Parts(part_name, category, Double.parseDouble(price));
                        available_parts.add(part);
                        System.out.println("part has benn added to the shop successfully.");
                    } else if (input3.equals("2")) {
                        System.out.print("Enter name: ");
                        String accessory_name = scn.nextLine();
                        String accessory_price;
                        while (true) {
                            System.out.print("Enter part price: ");
                            accessory_price = scn.nextLine();
                            try {
                                Double.parseDouble(accessory_price);
                            } catch (Exception x) {
                                System.out.println("Invalid price, try again.\n");
                                continue;
                            }
                            break;
                        }
                        Parts accessory = new Parts(accessory_name, "accessory", Double.parseDouble(accessory_price));
                        available_parts.add(accessory);
                        System.out.println("accessory has benn added to the shop successfully.");
                    } else {
                        System.out.println("Invalid input, try again.\n");
                    }
                    break;
                case "3":
                    break loop;
                default:
                    System.out.println("Invalid input, try again.\n");
                    break;
            }
        }
    }
}
