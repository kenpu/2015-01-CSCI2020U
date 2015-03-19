import java.io.*;
import java.net.*;

class Server {
    public static void main(String[] args) {
        int port = 2020;
        ServerSocket serversocket = null;
        boolean started = false;
        while(! started) {
            try {
                serversocket = new ServerSocket(port);
                started = true;
            } catch(IOException e) {
                port += 1;
            }
        }

        System.out.println("Server started at port:" + port);

        while(true) {
            try {
                Socket commsocket = serversocket.accept();
                System.out.println("Connected...");
                PrintWriter writer = new PrintWriter(commsocket.getOutputStream());
                writer.println("Hello from Java");
                writer.flush();
                commsocket.close();
            } catch(IOException e) {
                System.out.println("error on connection, " + e);
            }
        }
    }
}
