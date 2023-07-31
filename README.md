# # Oracle Next Education Challenge: Currency Converter

This is a project developed for the Oracle Java Training Challenge, which is a currency converter application. The app allows users to perform currency conversions between foreign currencies and the local currency, which in this case is the Colombian Peso. Users can select the conversion direction (from local currency to foreign currency or vice versa) and choose the specific currency for the conversion. Additionally, users have the ability to modify the exchange rate values for each currency by adjusting the fields in the program's constants.

## Key Features
- Conversion between the local currency (Colombian Peso) and foreign currencies.
- User-friendly interface with clear selection options and dialogues.
- Updated exchange rates for the foreign currencies included in the program.
- Ability to modify the exchange rate values for each currency through the program's constants.
- Cancellation function to exit the conversion process at any time.
- Results displayed with two decimal places for increased precision.

## How to Use
1. Run the application and select the conversion direction (from local currency to foreign currency or vice versa).
2. Choose the specific currency for the conversion from the list of available options.
3. Enter the amount you want to convert and click "Accept."
4. The application will display the conversion result with two decimal places for increased precision.
5. If you want to perform another conversion, simply select "Yes" when prompted.

## Modifying Exchange Rate Values for Each Currency
To modify the exchange rate values for each currency, the user can access the program's constants in the "ExchangeRate.java" file. There, you will find the following constants:

- `EXCHANGE_RATE_DOLLAR`: Exchange rate value for the US Dollar.
- `EXCHANGE_RATE_EURO`: Exchange rate value for the Euro.
- `EXCHANGE_RATE_LIBRA_ESTERLINA`: Exchange rate value for the British Pound Sterling.
- `EXCHANGE_RATE_YEN_JAPONES`: Exchange rate value for the Japanese Yen.
- `EXCHANGE_RATE_WON_SURCOREANO`: Exchange rate value for the South Korean Won.

Simply modify these values according to the current exchange rates to reflect the updated exchange rates.

## About the Oracle Java Training Challenge
The Oracle Java Training Challenge is an educational opportunity offered by Oracle to learn and improve skills in Java application development. This Currency Converter project was developed as part of this training to demonstrate the ability to use Java tools and concepts in building a practical application.

## Requirements
- Java Development Kit (JDK) 8 or higher.
- Graphical user interface (for the JOptionPaneGui version) or a console (for the ConsoleGui version) for user interaction.

Thank you for your interest in this Currency Converter project for the Oracle Java Training Challenge! If you have any questions or suggestions, feel free to reach out to me. Enjoy converting currencies with this Oracle Java training tool!