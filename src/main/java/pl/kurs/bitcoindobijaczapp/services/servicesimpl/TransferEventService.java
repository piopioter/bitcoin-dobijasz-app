package pl.kurs.bitcoindobijaczapp.services.servicesimpl;

import org.springframework.stereotype.Service;
import pl.kurs.bitcoindobijaczapp.dao.ITransferEventDao;
import pl.kurs.bitcoindobijaczapp.model.TransferEvent;
import pl.kurs.bitcoindobijaczapp.services.ITransferEventService;

import java.util.Objects;
import java.util.Optional;

/**
 * This class is a service implementation that handles the business logic
 */
@Service
public class TransferEventService implements ITransferEventService {

    private ITransferEventDao transferEventDao;

    public TransferEventService(ITransferEventDao transferEventDao) {
        this.transferEventDao = transferEventDao;
    }

    /**
     * Saves and validates the transferEvent object to the database
     * @param transferEvent The transferEvent object to be validate and saved
     */
    @Override
    public void saveEvent(TransferEvent transferEvent) {
        transferEventDao.save(
                Optional.ofNullable(transferEvent)
                        .filter(x -> Objects.isNull(x.getId()))
                        .orElseThrow());

    }
}
