import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Task6 {
    public Task6() {
        // create frame
        JFrame frame = new JFrame("My Frame");

        // create button
        Button button = new Button("OK");
        
        // create variables to count clicks and show
        int[] clickCount = { 0 };
        String textFieldContent = "Hello Java Click " + clickCount[0];
        
        // create text field
        TextField textField = new TextField(textFieldContent + clickCount[0]);

        // add action listener to increase count and change text
        button.addActionListener((ActionEvent e) -> {
            clickCount[0]++;
            textField.setText(textFieldContent + clickCount[0]);
        });

        // add components to the frame
        frame.add(button);
        frame.add(textField);

        // set layout of the frame
        frame.setLayout(new FlowLayout());

        // set frame size and visibility
        frame.setSize(400, 300);
        frame.setVisible(true);

        // add window listener to close the application
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
}
    public static void main(String[] args) {
        new Task6();
    }
}
