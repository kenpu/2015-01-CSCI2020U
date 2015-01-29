import part1.*;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> ngrams = Dictionary.ngrams("present", 3);
        System.out.println(ngrams);
    }
}
