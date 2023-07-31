package Gui;

import Constants.ExchangeRate;
import Converter.Converter;

import javax.swing.*;

public class JOptionPaneGui {

    public JOptionPaneGui() {
        view();
    }

    public void view() {
        Converter converter = new Converter();
        String[] conversionTypeOptions = {"Moneda local a moneda extranjera", "Moneda extranjera a moneda local"};
        int currencyType = 0;
        double result = 0;
        double value = 0;
        int operation = 0;
        int newOperation = 0;

        while (true) {
            operation = makeSelectorCurrency("Selecciona una opción de conversion  ", conversionTypeOptions);
            if (operation < 0) {
                break;
            }

            if (operation == converter.LOCAL_CURRENCY_TO_FOREIGN) {
                currencyType = makeSelectorCurrency("Seleccione la conversion de " + ExchangeRate.LOCAL_CURRENCY + " a ", ExchangeRate.CURRENCY_OPTIONS);
            } else {
                currencyType = makeSelectorCurrency("Seleccione la conversion a " + ExchangeRate.LOCAL_CURRENCY + " desde ", ExchangeRate.CURRENCY_OPTIONS);
            }
            if (currencyType < 0) {
                break;
            }

            String inputValue = JOptionPane.showInputDialog(null, "ingrese la cantidad que desea convertir");
            if (inputValue == null) {
                break;
            }
            if (inputValue.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo no puede estar vacio");
                continue;
            }
            try {
                value = Double.parseDouble(inputValue);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo puede ingresar valores numericos");
                continue;
            }

            result = converter.convertToCurrency(currencyType, value, operation);
            String operationName = (operation == converter.LOCAL_CURRENCY_TO_FOREIGN) ? "de " + ExchangeRate.LOCAL_CURRENCY + " a " : "a " + ExchangeRate.LOCAL_CURRENCY + " desde ";
            String currencyName = ExchangeRate.CURRENCY_OPTIONS[currencyType];
            String message = "El resultado de la conversion " + operationName + currencyName + " es: " + result;

            JOptionPane.showMessageDialog(null, message);

            newOperation = JOptionPane.showConfirmDialog(null, "Desea realizar otra conversion?");

            if (newOperation > 0) {
                JOptionPane.showMessageDialog(null, "Tenga un buen dia :)");
                break;
            }
        }

    }

    public static int makeSelectorCurrency(String title, String[] options) {

        int selectedOption = 0;

        JComboBox comboBox = new JComboBox<>(options);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelTitle = new JLabel(title);
        labelTitle.setAlignmentX(JLabel.LEFT);

        panel.add(labelTitle);
        panel.add(comboBox);

        int option = JOptionPane.showOptionDialog(
                null,
                panel,
                "Currency Converter",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                options[0]
        );
        if (option == JOptionPane.OK_OPTION || option == JOptionPane.YES_OPTION) {
            selectedOption = comboBox.getSelectedIndex();
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            return -1;
        }
        return selectedOption;

    }
}
