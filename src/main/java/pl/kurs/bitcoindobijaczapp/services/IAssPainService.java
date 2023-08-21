package pl.kurs.bitcoindobijaczapp.services;

import pl.kurs.bitcoindobijaczapp.enums.AssPainLevel;

import java.math.BigDecimal;

public interface IAssPainService {
    AssPainLevel calculateAssPainLevel(BigDecimal amount);

}
