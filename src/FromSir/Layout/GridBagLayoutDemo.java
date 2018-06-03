package FromSir.Layout;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GridBagLayoutDemo {

    public static void addComponentsToPane(Container pane) {

        JButton jbnButton;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gBC = new GridBagConstraints();
//fill  determines how the size of the component is adjusted in relation 
//        to the array of cells it occupies.
        gBC.fill = GridBagConstraints.HORIZONTAL;

        jbnButton = new JButton("Button 1");
//weightx and weighty
//Determines how free space is distributed between components in the container.
        gBC.weightx = 0.7;
//gridx and gridy
//Determines the position of the component in the container as coordinate 
//positions of cells in the grid, where (0, 0) is the top-left position in the grid.
        gBC.gridx = 0;
        gBC.gridy = 0;
        pane.add(jbnButton, gBC);

        JTextField jtf = new JTextField("TextField 1");
        gBC.weightx = 0.3;
        gBC.gridx = 1;
        gBC.gridy = 0;
        //jtf.setEditable(false);
        pane.add(jtf, gBC);

        jbnButton = new JButton("Button 3");
        gBC.gridx = 2;
        gBC.gridy = 0;
        //pane.add(jbnButton, gBC);

        jbnButton = new JButton("Button 4");
//ipadx and ipady
//Determines by how much the component size is to be increased above its minimum size.
        gBC.ipady = 40;     //This component has more breadth compared to other buttons
        gBC.weightx = 0.0;
        gBC.gridwidth = 2;//Specify number of columns (gridwidth) that a component can span to
        gBC.gridx = 0;
        gBC.gridy = 1;
        pane.add(jbnButton, gBC);

        JComboBox jcmbSample = new JComboBox(new String[]{"ComboBox 1", "hi", "hello"});
        gBC.ipady = 0;
        gBC.weighty = 1.0;
//anchor
//Determines where a component is positioned within the area allocated 
//to it in the container.
        gBC.anchor = GridBagConstraints.PAGE_END;
//insets
//Specifies the free space that is to be provided around the component within 
//the space allocated to it in the container.
        gBC.insets = new Insets(10, 0, 10, 0);  //Padding (anti clockwise)
        gBC.gridx = 1;
        gBC.gridwidth = 2;
        gBC.gridy = 2;
        pane.add(jcmbSample, gBC);
    }

    private static void createAndShowGUI() {

        //JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("GridBagLayout Source Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                createAndShowGUI();
            }
        });
    }
}
