class SequentialAccount {
    private int balance = 1000; // Initial balance of RM1000 as per specification

    public void deposit(int id, int amount) throws InterruptedException {
        System.out.println("Starting Transaction " + id + ": Deposit RM" + amount);
        Thread.sleep(100); // Simulate transaction processing time
        balance = balance + amount;
        System.out.println("Finished Transaction " + id);
        System.out.println("Current Balance: RM" + balance + "\n");
    }

    public void withdraw(int id, int amount) throws InterruptedException {
        System.out.println("Starting Transaction " + id + ": Withdraw RM" + amount);
        Thread.sleep(100); // Simulate transaction processing time
        balance = balance - amount;
        System.out.println("Finished Transaction " + id);
        System.out.println("Current Balance: RM" + balance + "\n");
    }

    public void checkBalance(int id) throws InterruptedException {
        System.out.println("Starting Transaction " + id + ": Balance Check");
        Thread.sleep(100); // Simulate transaction processing time
        System.out.println("Finished Transaction " + id);
        System.out.println("Current Balance: RM" + balance + "\n");
    }

    public void serviceCharge(int id, int amount) throws InterruptedException {
        System.out.println("Starting Transaction " + id + ": Service Charge RM" + amount);
        Thread.sleep(100); // Simulate transaction processing time
        balance = balance - amount;
        System.out.println("Finished Transaction " + id);
        System.out.println("Current Balance: RM" + balance + "\n");
    }
}

public class SequentialBanking {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("========== SEQUENTIAL BANKING PROCESSING ==========");
        SequentialAccount account = new SequentialAccount();

        // Processing exactly 8 individual transactions one-by-one
        account.deposit(1, 200);
        account.withdraw(2, 100);
        account.checkBalance(3);
        account.serviceCharge(4, 50);
        account.deposit(5, 300);
        account.withdraw(6, 50);
        account.checkBalance(7);
        account.serviceCharge(8, 10);
    }
}
