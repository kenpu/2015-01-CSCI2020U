import java.util.regex.*;
import java.io.*;

class ex {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(
                new FileReader("data/output.txt"));
        String line = reader.readLine();
        Pattern namep = Pattern.compile(">([A-Z- ]+)<");
        Pattern moneyp = Pattern.compile(">\\$([0-9,.]+)<");
        while(line != null) {
            Matcher m1 = namep.matcher(line);
            while(m1.find())
                System.out.println(m1.group(1));

            Matcher m2 = moneyp.matcher(line);
            while(m2.find())
                System.out.println(m2.group(1));
            line = reader.readLine();
        }
    }
}
