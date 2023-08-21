package pl.kurs.bitcoindobijaczapp.services.servicesimpl;

import org.springframework.stereotype.Service;
import pl.kurs.bitcoindobijaczapp.services.ICurrentUrlStringBuilder;

import static pl.kurs.bitcoindobijaczapp.config.AppConfig.*;

/**
 * This class is a service implementation that generate URL from external coinstats API.
 */
@Service
public class CoinStatsUrlStringBuilder implements ICurrentUrlStringBuilder {
    /** Generates a URL string for querying coin statistics based on the provided currency.
     * @param currency  request coin statistics  for the specified currency
     * @return the URL String constructed to fetch coin  statistic with the provided currency
     */
    @Override
    public String getUrl(String currency) {
        return new StringBuffer()
                .append(COINSTATS_APP)
                .append(COINSTATS_ENDPOINT)
                .append(COINSTATS_CURRENCY_QUERY)
                .append(currency)
                .toString();
    }
}
