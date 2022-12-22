import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10]; // Creates an Array of 10 buttons
    JButton[] funcButtons = new JButton[9]; // create an array of 8 operand/function buttons
    JButton addButton, subtractButton, multiButton, divButton;
    JButton deciButton, equalButton, delButton, acButton, negButton;
    JPanel panel;

    Font myFont = new Font("Times New Roman", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator; // holds the operand symbol

    Calculator() {

        frame = new JFrame("Calculator"); // creates a window with the title Calculators
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes the program when the window is closed
        frame.setSize(420, 550); // sets the size of the window
        frame.setLayout(null);

        textfield = new JTextField(); // creates a text box
        textfield.setBounds(50, 25, 300, 50); // sets the size of the text box
        textfield.setEditable(false); // Makes the text bot uneditable

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiButton = new JButton("*");
        divButton = new JButton("÷");
        deciButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("Del");
        acButton = new JButton("AC");
        negButton = new JButton("(-)");

        funcButtons[0] = addButton;
        funcButtons[1] = subtractButton;
        funcButtons[2] = multiButton;
        funcButtons[3] = divButton;
        funcButtons[4] = deciButton;
        funcButtons[5] = equalButton;
        funcButtons[6] = delButton;
        funcButtons[7] = acButton;
        funcButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont);
            funcButtons[i].setFocusable(false);
        }

        // iterates the through the loop to create 10 number buttons and assign the
        // font, and focusability to them
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50); // sets the location for delete button
        acButton.setBounds(250, 430, 100, 50); // sets the location for the clear button

        // creates a new gray panel of a given width, and height
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        // panel.setBackground(Color.GRAY);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiButton);
        panel.add(deciButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);
        panel.add(negButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(acButton);
        frame.add(textfield); // add the textfield to the window
        frame.setVisible(true); // allow the text field to be visible in the window
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == deciButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subtractButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == multiButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '÷';
            textfield.setText("");
        }
        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textfield.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '÷':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == acButton) {
            textfield.setText("");
            result = 0;
        }
        if (e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
    }
}