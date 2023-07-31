package Gui;

import Constants.ExchangeRate;
import Converter.Converter;

import java.util.Scanner;

public class ConsoleGui {

    public ConsoleGui(){
        view();
    }

    public void view() {
        Converter converter = new Converter();
        double value = 0;
        int currencyType = 0;
        int operation = 0;

        while (true) {
            int counter = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("-----------------------------------//-----------------------------------");
            System.out.println("Desea convertir:");
            System.out.println("0.Moneda local (" + ExchangeRate.LOCAL_CURRENCY + ") a moneda extranjera");
            System.out.println("1.Moneda extranjera a moneda local (" + ExchangeRate.LOCAL_CURRENCY + ")");
            operation = sc.nextInt();

            if (operation == 0) {
                System.out.println("Seleccione la moneda a la que desea convertir:");
            } else {
                System.out.println("Seleccione la moneda de la que desea convertir a moneda local:");
            }
            for (String currency : ExchangeRate.CURRENCY_OPTIONS) {
                System.out.println(counter + "." + currency);
                counter++;
            }
            currencyType = sc.nextInt();

            if (currencyType > (ExchangeRate.CURRENCY_OPTIONS.length - 1)) {
                System.out.println("Esa moneda no esta disponible para la conversion");
                continue;
            }

            sc.nextLine();
            System.out.println("ingrese la cantidad que desea convertir:");
            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
                sc.nextLine();
            } else {
                System.out.println("El valor ingresado no es valido");
                continue;
            }

            System.out.println(value);
            System.out.println("+-------------------+");
            System.out.println("| Result: " + converter.convertToCurrency(currencyType, value, operation) + " |");
            System.out.println("+-------------------+");
            System.out.println("\n");

            System.out.println("Desea realizar otra conversion?");
            System.out.println("false = No");
            System.out.println("true = Si");
            if (!sc.nextBoolean()) {
                break;
            }
        }
    }
}
