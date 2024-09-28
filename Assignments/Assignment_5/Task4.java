import java.awt.*;
import java.awt.event.*;

public class Task4 {
    public Task4() {
        // create a new frame
        Frame frame = new Frame("My Frame");

        // create a new menu bar
        MenuBar menuBar = new MenuBar();

        // create menus
        Menu fileMenu = new Menu("FILE");
        Menu helpMenu = new Menu("Help");

        // create menu items for file menu
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveAsItem = new MenuItem("Save as");
        
        // create menu items for help menu
        MenuItem aboutUsItem = new MenuItem("About us!");

        // add menu items to the file menu
        fileMenu.add(openItem);
        fileMenu.add(saveAsItem);

        // add menu item to the help menu
        helpMenu.add(aboutUsItem);
        
        // add menus to the menubar
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        // set the menubar to the frame
        frame.setMenuBar(menuBar);

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
        new Task4();
    }
}
