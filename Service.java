import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.server.ExportException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Service {



    Socket client;
    Service(ServerSocket server) throws Exception {

        Runnable readRunnable =()-> {
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
        Runnable writeRunnable =()-> {
            try {
                PrintWriter printWriter=new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
                String str;
                while (true) {
                    printWriter.println("server:"+bufferedReader.readLine());
                    printWriter.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        ExecutorService executorService= Executors.newFixedThreadPool(20);
        while (true) {
            client = server.accept();
            System.out.println("Linked");
            executorService.submit(readRunnable);
            executorService.submit(writeRunnable);
        }

    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(3333);
        Service serc = new Service(server);

    }

}
