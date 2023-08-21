package pl.kurs.bitcoindobijaczapp.services.servicesimpl;

import org.springframework.stereotype.Service;
import pl.kurs.bitcoindobijaczapp.services.ISimpleService;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This service class provides various methods for performing calculations related to cryptocurrency transaction
 */
@Service
public class SimpleService implements ISimpleService {
    /**
     * Calculate the amount of bitcoin based on the provided investment amount and past exchange rate
     * @param amount the initial investment  amount
     * @param pastRate the past exchange rate
     * @return the calculated amount of bitcoin
     */
    @Override
    public BigDecimal getAmountOfBtc(BigDecimal amount, BigDecimal pastRate) {
        return amount.divide(pastRate, 5, RoundingMode.HALF_UP);
    }

    /**
     * Calculate the  percentage profit based on  provided profit and initial investment amount
     * @param profit the profit amount
     * @param amount the initial investment  amount
     * @return the calculated profit percentage
     */
    @Override
    public BigDecimal calculateProfitPercentage(BigDecimal profit, BigDecimal amount) {
        return profit.divide(amount, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
    }

    /**
     * Converts the amount of bitcoin to fiat currency based on current exchange rate
     * @param amountOfBtc the amount of bitcoin
     * @param currentRate the current exchange rate
     * @return the earnings after selling bitcoin
     */
    @Override
    public BigDecimal getEarningsInFiatCurrency(BigDecimal amountOfBtc, BigDecimal currentRate) {
        return amountOfBtc.multiply(currentRate);
    }

    /**
     * Calculate the profit in fiat currency based on the earnings and initial investment amount
     * @param earnings the earnings in fiat currency
     * @param amount the initial investment amount
     * @return  the calculate profit in fiat currency
     */
    @Override
    public BigDecimal getProfitInFiatCurrency(BigDecimal earnings, BigDecimal amount) {
        return earnings.subtract(amount);
    }

}
