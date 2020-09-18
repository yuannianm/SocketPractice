import sun.security.x509.IPAddressName;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        InetAddress ip=InetAddress.getLocalHost();
        byte[] data="String".getBytes();
        DatagramSocket datagramSocket=new DatagramSocket();
        DatagramPacket datagramPacket=new DatagramPacket(data,data.length,ip,3333);
        datagramSocket.send(datagramPacket);
        System.out.println("已发送"+new String(data));
        datagramSocket.close();
    }
}
