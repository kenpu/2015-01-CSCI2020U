import uoit.csci2020u.util.*;

public class Test_StringUtil {
    public static void success() {
        System.out.println("Ok.");
    }
    public static void failure() {
        System.out.println("Failed.");
    }

    public static void main(String[] args) {
        String x = "hello";
        String y = StringUtil.reverse(x);

        if(y.compareTo("olleh") == 0) {
            success();
        } else {
            failure();
        }
    }
}
