package Converter;

import Constants.ExchangeRate;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Converter {
    public int LOCAL_CURRENCY_TO_FOREIGN = 0;

    public double convertToCurrency(int currencyType, double value, int operation) {
        double exchangeRate = getExchangeRate(currencyType);
        if (exchangeRate == 0) {
            throw new IllegalArgumentException("Invalid current type");
        }

        BigDecimal valueBg = new BigDecimal(Double.toString(value));
        BigDecimal exchangeRateBg = new BigDecimal(Double.toString(exchangeRate));

        BigDecimal result = operation == LOCAL_CURRENCY_TO_FOREIGN ? valueBg.multiply(exchangeRateBg) : valueBg.divide(exchangeRateBg, 2, RoundingMode.HALF_UP);
        return Double.parseDouble(result.setScale(2, RoundingMode.HALF_UP).toString());
    }

    private double getExchangeRate(int currencyType) {

        return switch (currencyType) {
            case (0) -> ExchangeRate.EXCHANGE_RATE_DOLLAR;
            case (1) -> ExchangeRate.EXCHANGE_RATE_EURO;
            case (2) -> ExchangeRate.EXCHANGE_RATE_LIBRA_ESTERLINA;
            case (3) -> ExchangeRate.EXCHANGE_RATE_YEN_JAPONES;
            case (4) -> ExchangeRate.EXCHANGE_RATE_WON_SURCOREANO;
            default -> 0;
        };
    }
}