package pl.kurs.bitcoindobijaczapp.dao;

import pl.kurs.bitcoindobijaczapp.model.TransferEvent;

public interface ITransferEventDao {
    void save(TransferEvent transferEvent);

}
