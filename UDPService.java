import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPService {
    public static void main(String[] args) throws Exception{

        DatagramSocket datagramSocket=new DatagramSocket(3333);
        System.out.println("服务启动");
        while (true) {
            byte[] data=new byte[1024];
            DatagramPacket datagramPacket=new DatagramPacket(data,data.length);
            datagramSocket.receive(datagramPacket);
            System.out.println("信息:" + new String (datagramPacket.getData())+"长度:"+datagramPacket.getLength());
        }
    }
}
