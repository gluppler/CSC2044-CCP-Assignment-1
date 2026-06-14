class SynchroAccount {
    private int balance = 1000;

    // Guarded critical section utilizing the internal intrinsic object lock
    public synchronized void deposit(int amount) {
        balance = balance + amount;
    }

    public synchronized int getBalance() {
        return balance;
    }
}

public class SynchroBanking {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("========== SYNCHRONIZED SOLUTION ==========");
        SynchroAccount account = new SynchroAccount();

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

        System.out.println("Expected final balance = RM201000");
        System.out.println("Actual final balance   = RM" + account.getBalance());
    }
}
