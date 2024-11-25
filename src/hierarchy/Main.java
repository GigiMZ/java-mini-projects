package hierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Project: Hierarchy
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.print("Enter budget ($): ");
            String budget = scn.nextLine();
            try {
                Double.parseDouble(budget);
            } catch (Exception z) {
                System.out.println("Invalid input, try again.\n");
                continue;
            }
            double dbudget = Double.parseDouble(budget);
            System.out.print("Enter amount of employees: ");
            String input = scn.nextLine();
            try {
                Integer.parseInt(input);
            } catch (Exception x) {
                System.out.println("Invalid input, try again.\n");
                continue;
            }
            Employee[] employees = new Employee[Integer.parseInt(input)];
            for (int i = 0; i < Integer.parseInt(input); i++) {
                employees[i] = new Employee();
                System.out.print("Enter the name of employee number " + (i+1) + ": ");
                employees[i].setName(scn.nextLine());
                while (true) {
                    System.out.print("Enter the level (low, medium, high) of employee number" + (i+1) + ": ");
                    String level = scn.nextLine();
                    if (level.equals("low") || level.equals("medium") || level.equals("high")) {
                        employees[i].setHierarchy_level(level);
                        break;
                    }
                    System.out.println("Invalid input, try again.\n");
                }
            }
            String level_to_compare = employees[0].getHierarchy_level();
            boolean same_level = true;
            for (int i = 1; i < employees.length; i++) {
                if (!employees[i].getHierarchy_level().equals(level_to_compare)) {
                    same_level = false;
                   break;
                }
            }
            if (same_level) {
                double each = dbudget / employees.length;
                for (Employee employee : employees) {
                    System.out.println("employee: "+employee.getName()+" gets $"+each);
                }
            }
            int employee_amount = employees.length;
            double each_percentage = (double) 100 / employee_amount;
            int low = 0;
            int mid = 0;
            int high = 0;
            for (Employee employee : employees) {
                switch (employee.getHierarchy_level()) {
                    case "low":
                        low++;
                        break;
                    case "medium":
                        mid++;
                        break;
                    case "high":
                        high++;
                        break;
                }
            }
            double low_percentage = each_percentage*low;
            double mid_percentage = each_percentage*mid;
            double high_percentage = each_percentage*high;
            int low_to_mid = 20; // this is amount of percentage medium gets from low
            int mid_to_high = 15; // this is amount of percentage high gets from medium

            double low_to_one_hundred = 100 / low_percentage;
            double low_to_mid_one_hundred = low_to_mid / low_to_one_hundred;

            double mid_to_one_hundred = 100 / mid_percentage;
            double mid_to_high_one_hundred = mid_to_high / mid_to_one_hundred;

            double final_low_percentage = low_percentage - low_to_mid_one_hundred;
            double final_mid_percentage = mid_percentage - mid_to_high_one_hundred + low_to_mid_one_hundred;
            double final_high_percentage = high_percentage + mid_to_high_one_hundred;

            System.out.println(final_low_percentage+final_mid_percentage+final_high_percentage+"%"); // math is correct (low+mid+high = 100%

            double each_low_percentage = final_low_percentage / low;
            double each_mid_percentage = final_mid_percentage / mid;
            double each_high_percentage = final_high_percentage / high;

            double each_low = dbudget * each_low_percentage / 100;
            double each_mid = dbudget * each_mid_percentage / 100;
            double each_high = dbudget * each_high_percentage / 100;

            System.out.println(each_low*low+each_mid*mid+each_high*high); // this should equal the total budget

            System.out.println("\nevery low level is getting $"+each_low);
            System.out.println("every medium level is getting $"+each_mid);
            System.out.println("every high level is getting $"+each_high+"\n");

            break;
        }
    }
}
