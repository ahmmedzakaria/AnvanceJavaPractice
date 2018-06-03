

package FromSir.RollingBallThread;

import java.awt.Point;
import java.util.Random;
import javax.swing.JOptionPane;

public class PositionUpdater implements Runnable
{
   
    public void run()
    {        
       int x , y;
       int incDecX;
       int incDecY;
       int xBoundry;
       int yBoundry;
       int[] direction= { 1 , -1 };
       int index = BallPanel.currentIndex++;               
       Random random = new Random();        

       incDecX = direction[random.nextInt( 2 )];
       incDecY = direction[random.nextInt( 2 )];
        
        while ( true )
        {
           x = BallPanel.point[index].x;
           y = BallPanel.point[index].y;
           xBoundry = BallPanel.xBoundry;
           yBoundry = BallPanel.yBoundry;
    
           if ( x == xBoundry )
              incDecX = incDecX * -1;
            
           if ( x == 2 )
               incDecX = incDecX * -1;
            
           if ( y == yBoundry )
               incDecY = incDecY * -1;
            
           if ( y == 2 )
               incDecY = incDecY * -1;              
         
           x = x + incDecX;
           y = y + incDecY;
           
           BallPanel.point[index].x = x;
           BallPanel.point[index].y = y;
           
           try
           {
              Thread.sleep( 10 );
           }
           catch ( InterruptedException e )
           {
               JOptionPane.showMessageDialog( null , "An error has occured\nclick OK to terminate." , "Error" , JOptionPane.ERROR_MESSAGE  );
               System.exit( 1 );
           } 
                         
        }
            
    }
    
}
