package pl.kurs.bitcoindobijaczapp.services.servicesimpl;

import org.springframework.stereotype.Service;
import pl.kurs.bitcoindobijaczapp.enums.AssPainLevel;
import pl.kurs.bitcoindobijaczapp.services.IAssPainService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Service to calculating Ass Pain
 */
@Service
public class AssPainService implements IAssPainService {

    private static Map<Long, AssPainLevel> assPainLevelMap;


    static {
        assPainLevelMap = new HashMap<>();
        assPainLevelMap.put(10L, AssPainLevel.NO_PAIN);
        assPainLevelMap.put(1_000L, AssPainLevel.MILD);
        assPainLevelMap.put(10_000L, AssPainLevel.MODERATE);
        assPainLevelMap.put(100_000L, AssPainLevel.SEVERE);
        assPainLevelMap.put(1_000_000L, AssPainLevel.VERY_SEVERE);
    }

    /**
     * Calculates the AssPain level based on the given  amount
     * @param amount used to calculating the ass pain level
     * @return the calculated  AssPainLevel
     */
    @Override
    public AssPainLevel calculateAssPainLevel(BigDecimal amount) {
        for (Map.Entry<Long, AssPainLevel> level : assPainLevelMap.entrySet()) {
            if (level.getKey().compareTo(amount.longValue()) >= 0)
                return AssPainLevel.values()[level.getValue().ordinal() - 1];

        }
        return AssPainLevel.values()[AssPainLevel.values().length - 1];

    }
}
