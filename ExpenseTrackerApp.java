import java.io.*;
import java.util.*;

class Expense {
    String date;
    String category;
    double amount;

    public Expense(String date, String category, double amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }
}

class ExpenseTracker {
    List<Expense> expenses;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(String date, String category, double amount) {
        Expense expense = new Expense(date, category, amount);
        expenses.add(expense);
        System.out.println("Expense added successfully.");
    }

    public void listExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to display.");
        } else {
            for (Expense expense : expenses) {
                System.out.println("Date: " + expense.date + ", Category: " + expense.category + ", Amount: $" + expense.amount);
            }
        }
    }

    public void displayCategorySummation() {
        Map<String, Double> categorySum = new HashMap<>();
        for (Expense expense : expenses) {
            categorySum.put(expense.category, categorySum.getOrDefault(expense.category, 0.0) + expense.amount);
        }

        for (Map.Entry<String, Double> entry : categorySum.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", Total Expenses: $" + entry.getValue());
        }
    }

    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(expenses);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            expenses = (List<Expense>) ois.readObject();
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class ExpenseTrackerApp {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Expense\n2. List Expenses\n3. Category-wise Summation\n4. Save Data\n5. Load Data\n6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter date (MM/DD/YYYY): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter amount: $");
                    double amount = scanner.nextDouble();
                    tracker.addExpense(date, category, amount);
                    break;
                case 2:
                    tracker.listExpenses();
                    break;
                case 3:
                    tracker.displayCategorySummation();
                    break;
                case 4:
                    System.out.print("Enter file name to save data: ");
                    String saveFileName = scanner.nextLine();
                    tracker.saveToFile(saveFileName);
                    break;
                case 5:
                    System.out.print("Enter file name to load data: ");
                    String loadFileName = scanner.nextLine();
                    tracker.loadFromFile(loadFileName);
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
