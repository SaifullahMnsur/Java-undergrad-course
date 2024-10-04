import java.awt.*;
import java.awt.event.*;

public class Calculator {
    
    public Calculator() {
        Frame frame = new Frame("Calculator");

        Panel topPanel = new Panel(new FlowLayout());
        Label inputLabel = new Label("Input");
        TextField inputATextField = new TextField();
        TextField inputBTextField = new TextField();
        inputATextField.setPreferredSize(new Dimension(100, 20));
        inputBTextField.setPreferredSize(new Dimension(100, 20));
        topPanel.add(inputLabel);
        topPanel.add(inputATextField);
        topPanel.add(inputBTextField);



        Panel midPanel = new Panel(new FlowLayout());
        Button addButton = new Button("+");
        addButton.setPreferredSize(new Dimension(30, 20));
        Button subButton = new Button("-");
        subButton.setPreferredSize(new Dimension(30, 20));
        Button multButton = new Button("*");
        multButton.setPreferredSize(new Dimension(30, 20));
        Button divButton = new Button("/");
        divButton.setPreferredSize(new Dimension(30, 20));


        midPanel.add(addButton);
        midPanel.add(subButton);
        midPanel.add(multButton);
        midPanel.add(divButton);

        Panel botPanel = new Panel(new FlowLayout());
        Label outLabel = new Label("Output");
        TextField outTextField = new TextField();
        outTextField.setPreferredSize(new Dimension(100, 20));
        botPanel.add(outLabel);
        botPanel.add(outTextField);

        frame.add(topPanel);
        frame.add(midPanel);
        frame.add(botPanel);

        frame.setLayout(new GridLayout(3, 1));
        frame.setSize(new Dimension(400, 200));
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window closing");
                frame.dispose();
                System.exit(0);
            }
        });



        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputA = inputATextField.getText();
                String inputB = inputBTextField.getText();

                Double inA = Double.parseDouble(inputA);
                Double inB = Double.parseDouble(inputB);

                Double out = inA + inB;

                outTextField.setText(out.toString());
            }
        });

        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputA = inputATextField.getText();
                String inputB = inputBTextField.getText();

                Double inA = Double.parseDouble(inputA);
                Double inB = Double.parseDouble(inputB);

                Double out = inA - inB;

                outTextField.setText(out.toString());
            }
        });

        multButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputA = inputATextField.getText();
                String inputB = inputBTextField.getText();

                Double inA = Double.parseDouble(inputA);
                Double inB = Double.parseDouble(inputB);

                Double out = inA * inB;

                outTextField.setText(out.toString());
            }
        });

        divButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputA = inputATextField.getText();
                String inputB = inputBTextField.getText();

                Double inA = Double.parseDouble(inputA);
                Double inB = Double.parseDouble(inputB);

                Double out = inA / inB;

                outTextField.setText(out.toString());
            }
        });
    }
    public static void main(String[] args) {
        new Calculator();
    }
}
