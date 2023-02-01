import java.net.*;
import java.io.*;
public class TCPClient
{
        public static void main(String args[]) throws Exception
        {
                Socket s=new Socket("localhost",8000);
                System.out.println("Enter filename");
                BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
                String fname=b.readLine();
                OutputStream ostream=s.getOutputStream();   //read the file name but is is not able to sent to server,so why we use PrintWriter class for That.
                PrintWriter pw=new PrintWriter(ostream,true);
				pw.println(fname);   //send the filename to server
                System.out.println("\nFile is sent to server\n");
                InputStream istream=s.getInputStream();
                BufferedReader d=new BufferedReader(new InputStreamReader(istream));
                System.out.println("File is:"+fname+"\n");
                String sc;
                while((sc=d.readLine())!=null)
                {
                        System.out.println(sc);
                }
                s.close();
                b.close();
                pw.close();
          }
}

               
