

public class FindFirstMatch
{
  public static int findFirstSpace( String str )
  {
      boolean found = false;
      
      int position = 0;
      
      while (position < str.length() && found == false)
      {
          if (str.charAt(position) == ' ')
          {
              found = true;
          }
          else
          {
              position += 1;
          }
          
      }
      
      if (!found)
          {
              position = -1;
          }
      
      return position;
      
  }
}
