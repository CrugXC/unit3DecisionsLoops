import java.util.Scanner;


public class CompareAdjacentValues
{
    public static void detectAdjacentDuplicates()
    {
        Scanner s1 = new Scanner(System.in);
        
        System.out.println("Enter a series of numbers. Enter a character to exit.");
        double input = s1.nextDouble();
        
        while (s1.hasNextDouble())
        {
            double previousInput = input;
            
            input = s1.nextDouble();
            
            
            if (previousInput == input)
            {
                System.out.println("Equal");
            }
            
        }
    }
}
