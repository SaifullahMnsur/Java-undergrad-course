import java.awt.*;
import java.awt.event.*;

public class Task1_Frame {
    
    public Task1_Frame() {
        // create a new Frame
        Frame frame = new Frame("My First GUI Frame");

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
