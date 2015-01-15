package fruits;

public class Apple {
    String color;
    public Apple(String c) {
        color = c;
    }
    @Override public String toString() {
        return "\"A " + color + " apple\"";
    }
}
