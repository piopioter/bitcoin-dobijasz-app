package pl.kurs.bitcoindobijaczapp.services;

import java.math.BigDecimal;

public interface ISimpleService {
    BigDecimal getAmountOfBtc(BigDecimal amount, BigDecimal pastRate);
    BigDecimal calculateProfitPercentage(BigDecimal profit, BigDecimal amount);
    BigDecimal getEarningsInFiatCurrency(BigDecimal amountOfBtc, BigDecimal currentRate);
    BigDecimal getProfitInFiatCurrency(BigDecimal earnings, BigDecimal amount);

}
