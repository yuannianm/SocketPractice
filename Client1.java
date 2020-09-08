import java.io.*;
import java.net.Socket;

public class Client1 {
    PrintWriter printWriter;

    Client1(Socket client) throws Exception {
        printWriter = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            printWriter.println(bufferedReader.readLine());
            printWriter.flush();
        }
    }
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("127.0.0.1", 3333);
        Client1 client1 = new Client1(client);
    }
}
