import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Task1_ExtendsJframe extends JFrame {
    
    public Task1_ExtendsJframe() {

        // set title for the frame
        setTitle("My First GUI Frame");

        // set the frame layout
        setLayout(new FlowLayout());

        // set frame size and visibility
        setSize(300, 300);
        setVisible(true);

        // add window listener to close the application
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new Task1_ExtendsJframe();
    }
}
