import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Task5 {
    public Task5() {
        JFrame frame = new JFrame("Radio/Combo Example");
        
        // create panels
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        
        // create labels
        JLabel label1 = new JLabel("Radio Button");
        JLabel label2 = new JLabel("Combo Box");
        JLabel label3 = new JLabel("Check Boxes");

        // items for panel 1
        // create check box group to hold radio buttons
        CheckboxGroup buttonGroup = new CheckboxGroup();

        // create radio buttons
        Checkbox radioButton1 = new Checkbox("4 Slices", buttonGroup, false);
        Checkbox radioButton2 = new Checkbox("8 Slices", buttonGroup, false);


        // items for panel 2
        // Add item names for combobox
        String[] items = {"Bird", "Cat", "Dog", "Rabbit", "Cow"};
        
        // create combo box for panel 2
        JComboBox<String> comboBox = new JComboBox<>(items);


        // items for panel 3
        //create check box options
        Checkbox option1 = new Checkbox("Anchovies");
        Checkbox option2 = new Checkbox("Garlic");


        // add components of panel 1
        panel1.add(label1);
        panel1.add(radioButton1);
        panel1.add(radioButton2);

        // add components of panel 2
        panel2.add(label2);
        panel2.add(comboBox);

        // add components of panel 3
        panel3.add(label3);
        panel3.add(option1);
        panel3.add(option2);

        // set layout of panels
        panel1.setLayout(new GridLayout(3, 1));
        panel1.setLayout(new GridLayout(2, 1));
        panel1.setLayout(new GridLayout(3, 1));

        // add panels to frame
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);

        // set the frame layout
        frame.setLayout(new GridLayout(1, 3));
        
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
        new Task5();
    }
}
