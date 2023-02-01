import java.net.*;
import java.io.*;
public class UDPClient
{
        public static void main(String args[]) throws IOException,SocketException,UnknownHostException
        {
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the message in binary form");
				String data=sc.nextLine();
				System.out.println("Enter the binary pattern of generator");
				String gen=sc.nextLine();
                String code=data;
				
				
                byte senddata[]=new byte[1024];
                byte receivedata[]=new byte[1024];
                DatagramSocket mySocket=new DatagramSocket();
				
                
                 while(code.length()<(data.length()+gen.length()-1))
                {
                        code+="0";
                }
				
				
				
                
                BufferedReader infromuser=new BufferedReader(new InputStreamReader(System.in));
                InetAddress myIP=InetAddress.getByName("localhost");
                
                DatagramPacket sendpacket=new DatagramPacket(code,myIP,9000);
                mySocket.send(sendpacket);
                DatagramPacket receivepacket=new DatagramPacket(code);
                mySocket.receive(receivepacket);
                String datatoDisplay=new String(receivepacket.getData());
                System.out.println(datatoDisplay);
                mySocket.close();
         }
}

