import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class Task1_JFrame {
    
    public Task1_JFrame() {
        // create a new Frame
        JFrame frame = new JFrame("My First GUI Frame");
        
        // set the frame layout
        frame.setLayout(new FlowLayout());

        // set frame size and visibility
        frame.setSize(300, 300);
        frame.setVisible(true);

        // add window listener to close the application
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new Task1_Frame();
    }
}
