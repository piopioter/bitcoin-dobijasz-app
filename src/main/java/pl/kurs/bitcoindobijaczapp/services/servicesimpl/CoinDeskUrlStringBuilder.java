package pl.kurs.bitcoindobijaczapp.services.servicesimpl;

import org.springframework.stereotype.Service;
import pl.kurs.bitcoindobijaczapp.services.IUrlStringBuilder;

import static pl.kurs.bitcoindobijaczapp.config.AppConfig.*;
/**
 * This class is a service implementation that generate URL from external coindesk API.
 */
@Service
public class CoinDeskUrlStringBuilder implements IUrlStringBuilder {
    /**
     * Generates a URL string for querying coin statistics based on the provided currency and date
     * @param currency request coin statistics  for the specified currency
     * @param pastDate  the historical date to fetch coin  statistic
     * @return the url string created to fetch coin statistic with the provided currency and date
     */
    @Override
    public String getUrl(String currency, String pastDate) {
        return new StringBuffer()
                .append(COINDESK_APP)
                .append(COINDESK_ENDPOINT)
                .append(COINDESK_DATE_QUERY)
                .append(pastDate)
                .append(COINDESK_CURRENCY_QUERY)
                .append(currency)
                .toString();
    }
}
