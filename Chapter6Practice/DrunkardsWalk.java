import java.awt.Point;
import java.util.Random;

public class DrunkardsWalk
{
    public static void main(String[] args)
    {
        Point pos = new Point(0,0);
        
        Random r1 = new Random();
        
        int direction;
        
        Point hold = new Point(0,0);
        
        for (int i = 0;
             i < 100;
             i ++)
        {
            direction = r1.nextInt(4);
            
            if (direction == 0)
            {
                hold.setLocation(pos);
                
                pos.setLocation(pos.getX() - 1, hold.getY());
            }
            
            else if (direction == 1)
            {
                hold.setLocation(pos);
                
                pos.setLocation(hold.getX(), pos.getY() + 1);
            }
            
            else if (direction == 2)
            {
                hold.setLocation(pos);
                
                pos.setLocation(pos.getX() + 1, hold.getY());
            }
            
            else
            {
                hold.setLocation(pos);
                
                pos.setLocation(hold.getX(), pos.getY() - 1);
            }
            
            if ((i % 10) == 0)
            {
                System.out.println(pos.getX() + ", " + pos.getY());
            }
        }
        
        System.out.println(pos.getX() + ", " + pos.getY());
    }
}
