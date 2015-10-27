
import java.util.Scanner;

public class FindMaxAndMin
{
   public static double findMax()
   {
       Scanner s1 = new Scanner(System.in);
       System.out.println("Enter a series of number or any character to quit.");
       
       double largest = s1.nextDouble();
       
       while (s1.hasNextDouble())
       {
           double input = s1.nextDouble();
           
           if (input > largest)
           {
               largest = input;
           }
       }
       
       return largest;
    }
}
