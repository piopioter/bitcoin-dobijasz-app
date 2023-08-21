package pl.kurs.bitcoindobijaczapp.services;

import pl.kurs.bitcoindobijaczapp.model.TransferEvent;

public interface ITransferEventService {
    void saveEvent(TransferEvent transferEvent);
}
