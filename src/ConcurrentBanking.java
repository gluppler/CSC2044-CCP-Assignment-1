class ConcurrentAccount {
    private int balance = 1000;

    public void deposit(int amount, int delay) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started Deposit RM" + amount);
        Thread.sleep(delay); // Simulate distinct processing duration
        balance = balance + amount;
        System.out.println(threadName + " finished Deposit RM" + amount);
    }

    public void withdraw(int amount, int delay) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started Withdraw RM" + amount);
        Thread.sleep(delay); // Simulate distinct processing duration
        balance = balance - amount;
        System.out.println(threadName + " finished Withdraw RM" + amount);
    }

    public void checkBalance(int delay) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started Balance Check");
        Thread.sleep(delay);
        System.out.println(threadName + " finished Balance Check");
    }

    public void serviceCharge(int amount, int delay) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started Service Charge RM" + amount);
        Thread.sleep(delay); // Simulate distinct processing duration
        balance = balance - amount;
        System.out.println(threadName + " finished Service Charge RM" + amount);
    }
}

public class ConcurrentBanking {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("========== CONCURRENT BANKING PROCESSING ==========");
        ConcurrentAccount account = new ConcurrentAccount();

        // Constructing threads via Runnable lambdas
        Thread t1 = new Thread(() -> {
            try { account.deposit(200, 150); } catch (InterruptedException e) {}
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            try { account.withdraw(100, 100); } catch (InterruptedException e) {}
        }, "Thread-2");

        Thread t3 = new Thread(() -> {
            try { account.checkBalance(50); } catch (InterruptedException e) {}
        }, "Thread-3");

        Thread t4 = new Thread(() -> {
            try { account.serviceCharge(50, 200); } catch (InterruptedException e) {}
        }, "Thread-4");

        // Explicitly invoking start() to allocate new JVM/OS execution call stacks
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Block the main orchestration thread until worker execution concludes
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}
