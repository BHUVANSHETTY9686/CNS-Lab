import java.net.*;
import java.io.*;
public class TCPServer
{
        public static void main(String args[]) throws Exception
        {
                ServerSocket sc=new ServerSocket(8000);
                System.out.println("Server is ready for connection");
                Socket s=sc.accept();
                System.out.println("Connection established");
                System.out.println("Connected with"+s.getInetAddress().toString());
                InputStream istream=s.getInputStream();
                BufferedReader b=new BufferedReader(new InputStreamReader(istream));
                String st=b.readLine();
                System.out.println("File name Received:"+st);
                
                BufferedReader d=new BufferedReader(new FileReader(st)); //Read the file form the server side storage
                OutputStream ostream=s.getOutputStream();
                PrintWriter pw=new PrintWriter(ostream,true);   // pw- object to send the file content to client
                String str;
                while((str=d.readLine())!=null)
                {
                        pw.println(str);
                }
                sc.close();
                s.close();
                b.close();
				d.close();
                pw.close();
         }
         
}
                
