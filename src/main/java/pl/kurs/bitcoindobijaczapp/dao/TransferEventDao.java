package pl.kurs.bitcoindobijaczapp.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kurs.bitcoindobijaczapp.model.TransferEvent;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This class is a typical DAO class
 */
@Repository
public class TransferEventDao implements ITransferEventDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Saves a transferEvent object to the database.
     * @param transferEvent object to be saved
     */
    @Transactional
    @Override
    public void save(TransferEvent transferEvent) {
        entityManager.persist(transferEvent);
    }
}
