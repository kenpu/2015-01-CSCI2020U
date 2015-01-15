import data.*;
import fruits.*;

class MyProg {
    public static void main(String[] colors) 
        throws Exception {
        List<Apple> apples = new List<Apple>();
        for(String c: colors) {
            apples.add(new Apple(c));
        }

        apples.print();
    }
}
