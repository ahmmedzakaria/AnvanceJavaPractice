
package FromSir.RollingBallThread;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;

public class BallPanel extends JPanel
{
    public static Point point[];
    public static int currentIndex;  
    public static int xBoundry;
    public static int yBoundry;
    private int ballLenght , ballWidth;    
    private final int MAX;
    private Color ballColor[];
    private ExecutorService executor;
    private Random random;    
    private Timer timer;

    
    public BallPanel()
    {
        // set the size of panel( width , height )
        this.setSize( 400 , 200 );
        
        // set the background color of panel
        this.setBackground( Color.WHITE );
        
        // register the MouseHandler class for handling mouse-clicks
        this.addMouseListener( new MouseHandler() );
        
        // initialize objects and variable        
        currentIndex = 0;
        xBoundry = 382;
        yBoundry = 233;        
        ballLenght = 10;
        ballWidth = 10;
        MAX = 10;        
        point = new Point[ MAX ];        
        ballColor = new Color[ MAX ];
        executor = Executors.newFixedThreadPool( MAX );        
        random = new Random();        
        timer = new Timer( 10 , new TimerHanlder() );
        timer.start();   
        
    } // end class constructor
    
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );                                       
                   
        // draw balls
        for ( int i = 0 ; i < currentIndex ; i++ )
        {
           g.setColor( ballColor[i] );             
           g.fillOval( point[i].x , point[i].y , ballLenght , ballWidth );                            
        }
        
    }
    
    public void increaseBallSize()
    {
        if ( ballWidth < 30 )
        {
           ballLenght++;
           ballWidth++;
           xBoundry--;
           yBoundry--;
        }
    }
    
    public void decreaseBallSize()
    {
        if ( ballWidth > 10 )
        {
           ballLenght--;
           ballWidth--;
           xBoundry++;
           yBoundry++;            
        }
    }   
    
    // private inner class for handling timer
    private class TimerHanlder implements ActionListener
    {
        
        public void actionPerformed( ActionEvent e )
        {
            repaint();
        }        
        
    } // end class TimerHandler        
   
    // private inner class for handling mouse-clicks
    private class MouseHandler extends MouseAdapter
    {
        
        public void mousePressed( MouseEvent e )
        {   
            // user clicked
            // if the number of balls is less than 10
            // create a new thread to manage the new ball position
            if ( currentIndex < MAX )
            {
               ballColor[ currentIndex ] = new Color( random.nextInt( 256 ),
                                                      random.nextInt( 256 ),
                                                      random.nextInt( 256 ) );
               
               point[ currentIndex ] = new Point( e.getX(),
                                                  e.getY() );
               
               executor.execute( new PositionUpdater() );              
            }                       
            
        } // end method mousePressed
        
    } // end class MouseHandler
           
} // end class BallPanel
