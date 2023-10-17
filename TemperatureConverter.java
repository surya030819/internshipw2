import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI {
    private JFrame frame;
    private JTextField inputField;
    private JLabel resultLabel;
    private JComboBox<String> unitComboBox;

    public TemperatureConverterGUI() {
        frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        inputField = new JTextField(10);
        frame.add(inputField);

        unitComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit"});
        frame.add(unitComboBox);

        JButton convertButton = new JButton("Convert");
        frame.add(convertButton);

        resultLabel = new JLabel("Result: ");
        frame.add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        frame.setVisible(true);
    }

    private void convertTemperature() {
        try {
            double temperature = Double.parseDouble(inputField.getText());
            String selectedUnit = unitComboBox.getSelectedItem().toString();

            if (selectedUnit.equals("Celsius")) {
                double convertedTemperature = (temperature * 9 / 5) + 32;
                resultLabel.setText("Result: " + convertedTemperature + " Fahrenheit");
            } else if (selectedUnit.equals("Fahrenheit")) {
                double convertedTemperature = (temperature - 32) * 5 / 9;
                resultLabel.setText("Result: " + convertedTemperature + " Celsius");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TemperatureConverterGUI();
            }
        });
    }
}