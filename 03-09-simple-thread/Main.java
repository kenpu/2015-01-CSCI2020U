import java.util.Random;

class Main {
    public static void main(String[] args) {
        Echo e1 = new Echo("CSCI 2020U");
        Echo e2 = new Echo("Sys Dev & Int");

        e1.start();
        e2.start();

        try {
            e1.join();
            e2.join();
            System.out.println("====== all done ========");
        } catch(InterruptedException e) {
            ;
        }
    }
}
class Echo extends Thread {
    String m;
    Random r = new Random();
    public Echo(String m) {
        this.m = m;
    }
    private void randSleep() {
        long t = r.nextInt(1000);
        try {
            Thread.sleep(t);
        } catch(InterruptedException e) {
            ;
        }
    }
    public void run() {
        for(int i=0; i < 20; i++) {
            this.randSleep();
            System.out.println(i + ": " + this.m);
        }
        System.out.println("[" + m + "] HAS WON......");
    }
}
