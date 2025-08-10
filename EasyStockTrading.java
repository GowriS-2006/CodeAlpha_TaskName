import java.util.Scanner;

public class EasyStockTrading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Market data
        String[] stocks = {"AAPL", "GOOG", "TSLA"};
        double[] prices = {150.0, 2800.0, 700.0};
        int[] portfolio = {0, 0, 0}; // shares owned
        double balance = 5000.0;

        while (true) {
            System.out.println("\n--- Stock Trading Menu ---");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("\nMarket Data:");
                for (int i = 0; i < stocks.length; i++) {
                    System.out.println((i+1) + ". " + stocks[i] + " - $" + prices[i]);
                }
            } 
            else if (choice == 2) {
                System.out.print("Enter stock number to buy: ");
                int stockNum = sc.nextInt() - 1;
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
                double cost = prices[stockNum] * qty;
                if (cost <= balance) {
                    balance -= cost;
                    portfolio[stockNum] += qty;
                    System.out.println("Bought " + qty + " shares of " + stocks[stockNum]);
                } else {
                    System.out.println("Not enough balance!");
                }
            } 
            else if (choice == 3) {
                System.out.print("Enter stock number to sell: ");
                int stockNum = sc.nextInt() - 1;
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
                if (qty <= portfolio[stockNum]) {
                    balance += prices[stockNum] * qty;
                    portfolio[stockNum] -= qty;
                    System.out.println("Sold " + qty + " shares of " + stocks[stockNum]);
                } else {
                    System.out.println("Not enough shares!");
                }
            } 
            else if (choice == 4) {
                System.out.println("\nPortfolio:");
                for (int i = 0; i < stocks.length; i++) {
                    System.out.println(stocks[i] + ": " + portfolio[i] + " shares");
                }
                System.out.println("Balance: $" + balance);
            } 
            else if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            } 
            else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
