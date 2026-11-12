package bll;

import dal.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Logic {

    private final Scanner scanner = new Scanner(System.in);
    private final Data data = new Data();
    private final LocalDate date = LocalDate.now();
    private String item = "";
    private double price = 0.0;
    private double total = 0.0;

    public void showExpenses() {
        List<String> list = data.getExpenses();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String[] parts = list.get(i).split(";", 3);
                System.out.println("======= " + "Buy " + (i + 1) + " =======");
                System.out.println("Date: " + parts[0]);
                System.out.println("Item: " + parts[1]);
                System.out.println("Price: " + parts[2] + " USD");
                System.out.println("=====================");
                total += Double.parseDouble(parts[2]);
            }
            System.out.println("Total: " + total + " USD");
            total = 0.0;
        }
        else
            System.out.println("You dont have any expenses yet!");
    }

    public void addExpense() {
        System.out.println("What did you buy?");
        System.out.print("> ");

        String input1 = scanner.nextLine();
        if (!input1.isBlank()) {
            this.item = input1;
        } else {
            System.out.println("Your item cannot be empty!");
            return;
        }

        System.out.println("What was the price?");
        System.out.print("> ");
        try {
            double input2 = Double.parseDouble(scanner.nextLine());
            if (input2 > -1) {
                this.price = input2;
            } else {
                System.out.println("Price cannot be negative!");
                return;
            }
        }

        catch (NumberFormatException e){
            System.out.println("Please enter a valid number!");
            return;
        }
        data.saveExpense(date, item, price);
    }
}

