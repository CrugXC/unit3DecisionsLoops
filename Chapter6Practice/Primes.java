
import java.util.Scanner;


public class Primes
{
    public static void main(String[] args)
    {
       Scanner s1 = new Scanner(System.in);
       
       System.out.print("Number: ");
       int num = s1.nextInt();
       
       int numCheck;
       boolean factors = false;
       
       for (int i = 0;
            i < num;
            i++)
       {
           numCheck = i;
               
            for(int a=2;
                a<numCheck;
                a++)
            { 
               if ( (num%a)==0 )
               {
                   factors = true;
               }
            
               if (factors = false)
               {
                   System.out.println(i);
               }
               
               factors = false;
               
               
           }
       }
    }
}