import sun.awt.windows.ThemeReader;

import java.io.*;
import java.net.Socket;

public class Client {
    PrintWriter printWriter;

    Client(Socket client) {
        Runnable writeRunnable = () -> {
            try {
                printWriter = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    printWriter.println("client:"+bufferedReader.readLine());
                    printWriter.flush();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        };
        Runnable readRunnable = () -> {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));
                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    System.out.println(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        Thread readThread =new Thread(readRunnable);
        Thread writeThread=new Thread(writeRunnable);
        readThread.start();
        writeThread.start();
    }

    public static void main(String[] args) throws Exception {
        Socket client = new Socket("127.0.0.1", 3333);
        Client client1 = new Client(client);
    }
}
