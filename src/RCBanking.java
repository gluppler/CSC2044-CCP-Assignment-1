class RCAccount {
    private int balance = 1000;

    // Unsafe shared data write operation lacking execution barriers
    public void deposit(int amount) {
        balance = balance + amount;
    }

    public int getBalance() {
        return balance;
    }
}

public class RCBanking {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("========== UNSAFE RACE CONDITION DEMONSTRATION ==========");
        RCAccount account = new RCAccount();

        // Each thread targets 100,000 iterations to maximize thread context-switch friction
        Runnable depositTask = () -> {
            for (int i = 0; i < 100000; i++) {
                account.deposit(1);
            }
        };

        Thread t1 = new Thread(depositTask, "Thread-1");
        Thread t2 = new Thread(depositTask, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Summary calculations
        System.out.println("Expected final balance = RM201000");
        System.out.println("Actual final balance   = RM" + account.getBalance());
    }
}
