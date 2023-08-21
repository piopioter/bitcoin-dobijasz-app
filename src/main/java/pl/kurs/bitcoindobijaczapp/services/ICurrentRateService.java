package pl.kurs.bitcoindobijaczapp.services;

import pl.kurs.bitcoindobijaczapp.exception.InvalidInputDataException;

import java.math.BigDecimal;

public interface ICurrentRateService {
    BigDecimal getRate(String currency) throws InvalidInputDataException;
}
