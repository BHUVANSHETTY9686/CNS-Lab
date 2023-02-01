import java.io.*;
import java.util.*;
public class crcprogram
{
        public static void main(String args[]) throws Exception
        {
                Scanner sc=new Scanner(System.in);
                System.out.println("Enter the message in binary form");
                String data=sc.nextLine();
                System.out.println("Enter the binary pattern of generator");
                String gen=sc.nextLine();
                String code=data;
                while(code.length()<(data.length()+gen.length()-1))
                {
                        code+="0";
                }
             
                code=data+div(code,gen);
                System.out.println("Code transmitted is "+code);
                String rem=div(code,gen);
                if(Integer.parseInt(rem)==0)
                        System.out.println("No error in data");
                 else
                        System.out.println("Error in data");
                System.out.println("Enter the position of the bit to be altered");
                int pos=sc.nextInt();
                if(code.charAt(pos)=='0')
                        code=code.substring(0,pos)+"1"+code.substring(pos+1);
                else
                        code=code.substring(0,pos)+"o"+code.substring(pos+1);
                System.out.println("Altered data: "+code);
                if(Integer.parseInt(div(code,gen))==0)
                        System.out.println("Error is not detected");
                else
                        System.out.println("Error is detected");
         }
         public static String div(String str1,String str2)
         {
                int pointer=str2.length();
                String result=str1.substring(0,pointer);
                String remainder="";
                for(int i=0;i<result.length();i++)
                        if(result.charAt(i)==str2.charAt(i))
                                remainder+="0";
                        else
                                remainder+="1";
                while(pointer<str1.length())
                {
                        if(remainder.charAt(0)=='0')
                        {
                                remainder=remainder.substring(1,remainder.length());
                                remainder+=String.valueOf(str1.charAt(pointer));
                                pointer++;
                         }
                         result=remainder;
                         remainder="";
                         for(int i=0;i<result.length();i++)
                                       if(result.charAt(i)==str2.charAt(i))
                                                remainder+="0";
                                       else
                                                remainder+="1";
                                
                  }
                  
                  return remainder.substring(1,remainder.length());
            }
 }
                   
                        
                
               
