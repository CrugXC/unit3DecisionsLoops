import java.util.Scanner;

public class Spectrum
{


    public static void main(String[] args)
    {
        Scanner s1 = new Scanner(System.in);
        System.out.print("Wavelength: ");
        double wavelength = s1.nextDouble();
        
        if (wavelength < 1e-11)
        {
            System.out.println("Gamma Rays");
        }

        else if (wavelength < 1e-8)
        {
            System.out.println("X-Rays");
        }

        else if (wavelength < 4e-7)
        {
            System.out.println("Ultraviolet");
        }

        else if (wavelength < 7e-7)
        {
            System.out.println("Visible Light");
        }

        else if (wavelength < 1e-3)
        {
            System.out.println("Infrared");
        }

        else if (wavelength < 1e-1)
        {
            System.out.println("Microwave");
        }

        else
        {
            System.out.println("Radio Waves");
        }
    }
}

