class Account {
    public float balance;
    public Account(float init) {
        this.balance = init;
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
            // deposit
            float x = a.balance;
            x += 1000f;
            a.balance = x;
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
            float x = a.balance;
            x -= 1000f;
            a.balance = x;
        }
    }
}

class AccountRace {
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
