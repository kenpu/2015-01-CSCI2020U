import java.io.*;

class Driver {
    public static void main(String[] args) throws Exception {
        String path = args[0];

        Process p = Runtime.getRuntime().exec(
                new String[]{"ls", path});
        InputStream in = p.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String s = reader.readLine();
        while(s != null) {
            System.out.println(s);
            s = reader.readLine();
        }
        reader.close();
    }
}
