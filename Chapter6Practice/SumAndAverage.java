import java.util.Scanner;

public class SumAndAverage
{
 public static double average()
 {
     Scanner s1 = new Scanner(System.in);
     
     double sum = 0;
     int count = 0;
     System.out.println("Enter a series of doubles. Enter n to quit.");
     
     while(s1.hasNextDouble())
     {
         System.out.print("Input: ");
         double input = s1.nextDouble();
         sum += input;
         count += 1;
     }
     
     double average = 0;
     if(count > 0)
     {
         average = sum/count;
     }
     
     return average;
 }
}
