import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Task7 {
    public Task7() {
        // create a frame
        JFrame frame = new JFrame("Click a Button");

        Button buttonRed = new Button("Red");
        Button buttonGreen = new Button("Green");

        buttonGreen.addActionListener((ActionEvent e) -> {
            frame.getContentPane().setBackground(Color.GREEN);
        });

        buttonRed.addActionListener((ActionEvent e) -> {
            frame.getContentPane().setBackground(Color.RED);
        });
        
        frame.add(buttonRed);
        frame.add(buttonGreen);

        // set layout of the frame
        frame.setLayout(new FlowLayout());

        // set frame size and visibility
        frame.setSize(400, 300);
        frame.setVisible(true);

        // add window listener to close the application
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) {
        new Task7();
    }
}
