import java.util.Scanner;


public class Factor
{
    public static void main(String[] args)
    {
       Scanner s1 = new Scanner(System.in);
       
       System.out.print("Number: ");
       int num = s1.nextInt();
       
       for(int i=2;
           i<num;
           i++)
       { 
           if ( (num%i)==0 )
           {
               System.out.println( i );
           }
        }
    }  
}

