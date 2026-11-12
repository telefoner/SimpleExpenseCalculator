package gui;

import bll.Logic;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        Logic logic = new Logic();

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "add":
                    logic.addExpense();
                    break;

                case "view":
                    logic.showExpenses();
                    break;

                case "exit":
                    return;

                case "help":
                    System.out.println("add - to add items to your expenses list\nview - to view your expenses list\nexit - to end the program");
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }
}
