import java.awt.*;
import java.awt.event.*;

public class Task2 {
    private Frame masterFrame, tempFrame;

    public Task2() {
        // create master frame
        this.masterFrame = new Frame("Click to Close Everything");
        this.masterFrame.setSize(400, 300);
        this.masterFrame.setLayout(new FlowLayout());

        // create temporary frame
        this.tempFrame = new Frame("Click to Close Just This");
        this.tempFrame.setSize(300, 300);
        this.tempFrame.setLayout(new FlowLayout());

        // add window listener to close temporary frame
        this.tempFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                tempFrame.dispose();
            }
        });

        // add window listener to open both frame
        this.masterFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                if (tempFrame != null) {
                    tempFrame.dispose();
                }
                masterFrame.dispose();
                System.exit(0);
            }
        });

        this.masterFrame.setVisible(true);
        this.tempFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Task2();
    }
}
