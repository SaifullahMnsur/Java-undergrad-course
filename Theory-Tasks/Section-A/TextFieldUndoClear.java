import javax.swing.*;
import javax.swing.undo.*;
import java.awt.*;
import java.awt.event.*;

public class TextFieldUndoClear {
    public TextFieldUndoClear() {
        JFrame frame = new JFrame("Text Field with Undo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JTextField textField = new JTextField(20);
        JButton undoButton = new JButton("Undo");
        JButton clearButton = new JButton("Clear");

        UndoManager undoManager = new UndoManager();

        textField.getDocument().addUndoableEditListener(e -> {
            undoManager.addEdit(e.getEdit());
        });

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (undoManager.canUndo()) {
                        undoManager.undo();
                    }
                } catch (CannotUndoException ex) {
                    ex.printStackTrace();
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        frame.add(textField);
        frame.add(undoButton);
        frame.add(clearButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TextFieldUndoClear();
    }
}
