import java.net.*;
import java.io.*;
public class UDPClient
{
        public static void main(String args[]) throws IOException,SocketException,UnknownHostException
        {
                byte senddata[]=new byte[1024];
                byte receivedata[]=new byte[1024];
                DatagramSocket mySocket=new DatagramSocket();
                System.out.println("Enter Data");
                BufferedReader infromuser=new BufferedReader(new InputStreamReader(System.in));
                InetAddress myIP=InetAddress.getByName("localhost");
                String Data =infromuser.readLine();
                senddata=Data.getBytes();
                DatagramPacket sendpacket=new DatagramPacket(senddata,senddata.length,myIP,9000);
                mySocket.send(sendpacket);
                DatagramPacket receivepacket=new DatagramPacket(receivedata,receivedata.length);
                mySocket.receive(receivepacket);
                String datatoDisplay=new String(receivepacket.getData());
                System.out.println(datatoDisplay);
                mySocket.close();
         }
}

