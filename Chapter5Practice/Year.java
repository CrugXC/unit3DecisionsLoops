import java.util.Scanner;

public class Year
{
    private int selectedYear;

    public Year()
    {
    }
    
    
    public void isLeapYear()
    {
        Scanner s1 = new Scanner(System.in);

        System.out.print("Year: ");

        selectedYear = s1.nextInt();


        if (selectedYear % 4 == 0 && (selectedYear % 100 != 0 || selectedYear % 400 == 0))
        {
           System.out.println("Leap Year");
        }

        else    
        {
            System.out.println("Not Leap Year");
        }
    }
}
 