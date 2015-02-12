import java.util.regex.*;

public class SimpleRe {
    public static void main(String []args) {
        String paragraph = "Mr. Einstein wrote a letter to Prof. Feynman.";
        String regex = "(Mr|Prof)\\.\\s+([A-Z][a-z]+)";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(paragraph);

        while(m.find()) {
            System.out.println("Text contains names");
            System.out.println("    title: " + m.group(1));
            System.out.println("    name : " + m.group(2));
        }
    }
}
