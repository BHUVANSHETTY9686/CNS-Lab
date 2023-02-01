import java.util.Scanner;
import java.net.*;
import java.io.*;
public class UDPServer
{
        public static void main(String args[]) throws SocketException,IOException
        {
                DatagramSocket datagramSocket=new DatagramSocket(9000);
                byte senddata[]=new byte[1024];
                byte receivedata[]=new byte[1024];
                while(true)
                {
                        DatagramPacket receivePacket=new DatagramPacket(receivedata,receivedata.length);
                        datagramSocket.receive(receivePacket);
                        String data=new String(receivePacket.getData());
                        System.out.println("Client Data\n"+data);
                        InetAddress clientIPAddress=receivePacket.getAddress();
                        int port=receivePacket.getPort();
                        System.out.println("Enter data to send to client");
                        Scanner scan=new Scanner(System.in);
                        String datatosend=scan.next();
                        senddata=datatosend.getBytes();
                        DatagramPacket senddatatoclient=new DatagramPacket(senddata,senddata.length,clientIPAddress,port);
                        datagramSocket.send(senddatatoclient);
                  }
          }
}

