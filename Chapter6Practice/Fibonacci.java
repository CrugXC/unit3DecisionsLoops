import java.util.Scanner;

public class Fibonacci
{
   public static void main (String[] args)
   {
       int f1 = 1;
       int f2 = 1;
       int fnew = 1;
       
       Scanner s1 = new Scanner(System.in);
       System.out.print("Term: ");
       int term = s1.nextInt();
       
       boolean change = true;
       
       for( int i = 2;
            i < term;
            i ++)
       {
           if (change == true)
           {
               fnew = f1 + f2;
               f1 = fnew;
               change = false;
           }
           
           else
           {
               fnew = f1 + f2;
               f2 = fnew;
               change = true;
           }
       }
       
       
       System.out.println(fnew);
   }

}
