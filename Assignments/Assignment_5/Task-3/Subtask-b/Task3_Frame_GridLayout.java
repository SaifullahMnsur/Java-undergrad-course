import java.awt.*;
import java.awt.event.*;

public class Task3_Frame_GridLayout {
    
    public Task3_Frame_GridLayout() {
        // create a new Frame
        Frame frame = new Frame("My Frame");
        
        // create a new label
        Label label = new Label("Label");

        // create search box
        TextField textField = new TextField("Text");
        
        // create a new button
        Button button = new Button("Submit");

        // add components to the frame
        frame.add(label);
        frame.add(textField);
        frame.add(button);

        // set the frame layout
        frame.setLayout(new GridLayout());

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
        new Task3_Frame_GridLayout();
    }
}
