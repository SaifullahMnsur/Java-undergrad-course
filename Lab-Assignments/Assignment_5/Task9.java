import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Task9 {
    public Task9() {
        // create a frame
        JFrame frame = new JFrame("Fehrenheight to Celcius");

        Panel panel1 = new Panel();

        // create panel 1
        Label label1 = new Label("Enter Fehrenheight temperatur: ");
        TextField textField1 = new TextField();
        textField1.setPreferredSize(new Dimension(75,25));

        panel1.add(label1);
        panel1.add(textField1);

        // create panel 2
        Panel panel2 = new Panel();

        Label label2 = new Label("Temperatur in Celcius: ");
        TextField textField2 = new TextField();
        textField2.setPreferredSize(new Dimension(75,25));
        
        panel2.add(label2);
        panel2.add(textField2);

        // create panel 3
        Panel panel3 = new Panel();
        Button convertToFer = new Button("Convert to Fehrenheight");
        Button convertToCel = new Button("Convert to Celcius");

        convertToFer.addActionListener((ActionEvent e) -> {
            double F = Double.parseDouble(textField1.getText());
            System.out.println("F: " + F);
            double C = ((F-32.0) * 5.0) / 9.0;
            System.out.println("C: " + C);
            String output = String.format("%.2f", C);
            System.out.println("Output: " + output);
            textField2.setText(output);
        });

        convertToCel.addActionListener((ActionEvent e) -> {
            double C = Double.parseDouble(textField2.getText());
            double F = (9.0/5.0 * C) + 32.0;
            textField1.setText(String.format("%.2f", F));
        });


        panel3.add(convertToFer);
        panel3.add(convertToCel);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);

        // set layout of the frame
        frame.setLayout(new GridLayout(3,1));

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
        new Task9();
    }
}
