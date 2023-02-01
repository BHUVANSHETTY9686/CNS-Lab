import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class RSA
{
	private BigInteger p,q,n,phi,e,d;
	private Random r;
	int bitlength=1024;
	public RSA()
	{
		r=new Random();
		p=BigInteger.probablePrime(bitlength,r);
		q=BigInteger.probablePrime(bitlength,r);
		n=p.multiply(q);
		phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		e=BigInteger.probablePrime(bitlength/2,r);
		while(phi.gcd(e).compareTo(BigInteger.ONE)>0 && (e.compareTo(phi)<0))
			e.add(BigInteger.ONE);
		d=e.modInverse(phi);
	}
	public RSA(BigInteger e,BigInteger d,BigInteger n)
	{
		this.e=e;
		this.d=d;
		this.n=n;
	}
	public static void main(String [] args) throws Exception
	{
		RSA rs=new RSA();
		DataInputStream in=new DataInputStream(System.in);
		System.out.println("Enter the plain text");
		String textstring=in.readLine();
		System.out.println("The encrypting message is: "+textstring);
		System.out.println("The plain text in bytes: "+bytestostring(textstring.getBytes()));
		byte [] encrypted=rs.encrypt(textstring.getBytes());
		byte [] decrypted=rs.decrypt(encrypted);
		System.out.println("Decrypted byte: "+bytestostring(decrypted));
		System.out.println("Decrypted string: "+new String(decrypted));
    }
    private static String bytestostring(byte [] encrypted)
    {
        String text="";
        for(byte b:encrypted)
        {
            text=text+Byte.toString(b);
        }
        return text;
    }
    public byte[] encrypt(byte [] message)
    {
        return (new BigInteger(message)).modPow(e,n).toByteArray();
    }
    public byte [] decrypt(byte [] message)
    {
        return(new BigInteger(message)).modPow(d,n).toByteArray();
    }
}