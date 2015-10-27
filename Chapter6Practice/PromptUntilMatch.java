import java.util.Scanner;


public class PromptUntilMatch
{
    public static double promptUntilMatch()
    {
        Scanner s1 = new Scanner(System.in);
        
        boolean valid = false;
        
        double input;
        
        do
        {
            System.out.println("Please enter a positive value less than 100.");
            
            input = s1.nextDouble();
            
            if (input > 0 && input < 100)
            {
                valid = true;
            }
        }
        
        while(!valid);
        
        return input;
    }
        
}
