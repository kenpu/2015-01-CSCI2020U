class Account {
    public double balance;
    public Account(float init) {
        this.balance = init;
    }
    public synchronized void deposit(float amount) {
        this.balance += amount;
    }
    public synchronized void withdraw(float amount) {
        this.balance -= amount;
    }
}

class Earner extends Thread {
    Account a;
    int iter;
    public Earner(Account a, int iter) {
        this.a = a;
        this.iter = iter;
    }
    @Override
    public void run() {
        for(int i=0; i < iter; i++) {
            a.deposit(1000f);
        }
    }
}

class Spender extends Earner {
    public Spender(Account a, int iter) {
        super(a, iter);
    }
    @Override
    public void run() {
        for(int i=0; i < iter; i++) {
            a.withdraw(1000f);
        }
    }
}

class AccountRaceSyncMethod {
    public static void main(String[] args) throws Exception {
        int n = Integer.valueOf(args[0]);
        Account a = new Account(5000.0f);
        Thread t = new Earner(a, n);
        Thread s = new Spender(a, n);

        t.start();
        s.start();

        t.join();
        s.join();

        System.out.println("Account balance = " + a.balance);
    }
}
