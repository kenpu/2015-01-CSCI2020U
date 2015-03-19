import java.net.*;
import java.io.*;

class Client {
    public static void main(String[] args) throws Exception {
        Socket commsocket = new Socket(args[0], Integer.valueOf(args[1]));
        // read from server
        InputStream in = commsocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String s = reader.readLine();
        if(s != null) {
            System.out.println(">" + s);
        }
        commsocket.close();
    }
}
