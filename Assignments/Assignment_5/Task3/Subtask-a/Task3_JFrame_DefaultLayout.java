import java.awt.*;
import java.awt.event.*;

public class Task3_JFrame_DefaultLayout {
    
    public Task3_JFrame_DefaultLayout() {
        // create a new Frame
        Frame frame = new Frame("My Frame");
        
        // create a new label
        Label label = new Label("Label");

        // create search box
        TextField textField = new TextField("Text");
        
        // create a new button
        Button button = new Button("Submit");

        // add components to the frame
        frame.add(label, BorderLayout.EAST);
        frame.add(textField, BorderLayout.CENTER);
        frame.add(button, BorderLayout.WEST);

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
        new Task3_JFrame_DefaultLayout();
    }
}
