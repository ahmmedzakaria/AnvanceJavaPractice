
package FromSir.RollingBallThread;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BallFrame extends JFrame
{
    
    public BallFrame()
    {
        this.setTitle( "Bouncing Balls" );        

        JMenuBar menuBar = new JMenuBar();
        final BallPanel panel = new BallPanel();
        
        JMenu fileMenu;        
        fileMenu = new JMenu( "File" );
        fileMenu.setMnemonic( 'F' );
        
        JMenuItem exitItem = new JMenuItem( "Exit" );
        exitItem.setMnemonic( 'x');
        exitItem.addActionListener(
                // anonymous inner class
                new ActionListener()        
                {
                    public void actionPerformed( ActionEvent e )
                    {
                        System.exit( 0 );
                    }
            
                 }
        );
        fileMenu.add( exitItem );
        
        JMenu optionMenu = new JMenu( "Option" );
        optionMenu.setMnemonic( 'O');
        
        JMenuItem incBallSizeItem = new JMenuItem( "increase ball size" );
        incBallSizeItem.setMnemonic( 'i');
        incBallSizeItem.addActionListener(
                // anonymous inner class                
                new ActionListener()
                {
                    public void actionPerformed( ActionEvent e )
                    {
                        panel.increaseBallSize();
                    }
                }
        );
        optionMenu.add( incBallSizeItem );
        
        JMenuItem decBallSizeItem = new JMenuItem( "decrease ball size" );
        decBallSizeItem.setMnemonic( 'd');
        decBallSizeItem.addActionListener(
                // anonymous inner class                
                new ActionListener()
                {
                    public void actionPerformed( ActionEvent e )
                    {
                        panel.decreaseBallSize();
                    }                    
                }
        );
        optionMenu.add( decBallSizeItem );   
        
        menuBar.add( fileMenu );
        menuBar.add( optionMenu );
        
        this.setJMenuBar( menuBar );                
        this.add( panel );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        //this.add( panel );
        this.setSize( 400 , 300 );
        this.setResizable( false );
        this.setVisible( true ); 
        
        JOptionPane.showMessageDialog( this , "To add new balls just click on white area" ,
                                       "Bouncing Ball" , JOptionPane.INFORMATION_MESSAGE );
        
    } // end class constructor
    
} // end class BallFrame
