import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Task8 {

    private MenuItem CreateMenuItem(String name, JLabel label) {
        MenuItem menuItem = new MenuItem(name);
        menuItem.addActionListener((ActionEvent e) -> {
            label.setText("This label is for " + name);
        });
        return menuItem;
    }

    public Task8() {
        // create frame
        JFrame frame = new JFrame("Simple Menu Program");

        JLabel label = new JLabel();

        // create a new menu bar
        MenuBar menuBar = new MenuBar();

        String[] names = {"Dhaka", "Chattogram", "Rajshahi", "Sylhet", "Barishal", "Khulna", "Mymensingh", "Rangpur"};

        // create menus
        Menu divsMenu = new Menu("BD Divisions");
        Menu ctsMenu = new Menu("BD Cities");

        // create menu items for Division menu
        for (int i = 0; i < 8; i++) {
            divsMenu.add(this.CreateMenuItem(names[i] + " Divsion", label));
            ctsMenu.add(this.CreateMenuItem(names[i] + " City", label));
        }
        
        // add menus to the menubar
        menuBar.add(divsMenu);
        menuBar.add(ctsMenu);

        // set the menubar to the frame
        frame.setMenuBar(menuBar);
        frame.add(label);

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
        new Task8();
    }
}