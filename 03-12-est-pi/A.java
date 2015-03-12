import java.util.Random;

class A {
    public static void main(String[] args) {
        Random r = new Random();
        long m = 0, n = 0;
        float x, y;
        while(true) {
            n += 1;
            x = r.nextFloat();
            y = r.nextFloat();
            if(x * x + y * y <= 1) m += 1;
            
            double pi = (double)m/n * 4.0;
            if(n % 1000 == 0)
                System.out.println(n + ": pi ~ " + pi);
        }
    }
}
