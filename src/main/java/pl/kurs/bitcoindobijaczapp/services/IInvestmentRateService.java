package pl.kurs.bitcoindobijaczapp.services;

import pl.kurs.bitcoindobijaczapp.exception.InvalidInputDataException;

import java.math.BigDecimal;

public interface IInvestmentRateService {
    BigDecimal getRate(String investmentDate, String currency) throws InvalidInputDataException;
}
