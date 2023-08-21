package pl.kurs.bitcoindobijaczapp.services;

import pl.kurs.bitcoindobijaczapp.exception.InvalidInputDataException;
import pl.kurs.bitcoindobijaczapp.model.TransferEvent;

import java.math.BigDecimal;

public interface IBitcoinService {
    void invest(String investmentDate, String currency, BigDecimal amount) throws InvalidInputDataException;




}
