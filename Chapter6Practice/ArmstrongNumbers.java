

public class ArmstrongNumbers
{
   public static void main(String[] args)
   {
       
       String number = "";
       int length;
       boolean addCheck = false;
       boolean cubeCheck = false;
       int add = 0;
       int cube = 0;
       
       for (int i = 0;
            i < 1000;
            i ++)
       {
           number = "" + i;
           
           length = number.length();
           
           for (int a = 0;
                a < length;
                a++)
           {
               add += Integer.parseInt((number.substring(a, a+1) + "3"));
               cube += Math.pow((Integer.parseInt(number.substring(a, a+1))), 3);
           }
           
           if (add ==  Integer.parseInt(number))
           {
               addCheck = true;
           }
           
           if (cube == Integer.parseInt(number))
           {
               addCheck = true;
           }
           
           if (addCheck == true && cubeCheck == true)
           {
               System.out.println(number);
           }
           addCheck = false;
           addCheck = false;
           add = 0;
           cube = 0;           
       }
   }
}
