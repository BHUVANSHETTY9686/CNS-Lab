import java.io.*;
import java.util.*;
public class leakyBucket
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the bucket size");
		int size=sc.nextInt();
		int a[]=new int[size];
		System.out.println("Enter the number of packets");
		int p=sc.nextInt();
		System.out.println("Enter the values of the packet");
		for(int i=0;i<p;i++)
			a[i]=sc.nextInt();

		System.out.println("Enter the output rate");
		int out=sc.nextInt();
		for(int i=0;i<p;i++)
		{
			if(a[i]>size)
				System.out.println("Bucket overflow and value is"+" "+a[i]);
			else
			{
				if(a[i]==out)
				{
					System.out.println("Packet Transmitted ");
				}
				else if(a[i]>out)
				{
					while(a[i]!=0 && a[i]>out)
					{
						System.out.println("Packet Transmitted "+out);
						a[i]=a[i]-out;
					}
				}
				System.out.println("Packet Transmitted "+a[i]);
			}
		}
	}
}