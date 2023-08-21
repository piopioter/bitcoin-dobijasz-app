package pl.kurs.bitcoindobijaczapp.services.servicesimpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.kurs.bitcoindobijaczapp.exception.InvalidInputDataException;
import pl.kurs.bitcoindobijaczapp.services.ICurrentRateService;
import pl.kurs.bitcoindobijaczapp.services.ICurrentUrlStringBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Optional;

/**
 *This class retrieve the current rate of specified crypto from JSON
 */
@Service
public class CoinStatsCurrentRateService implements ICurrentRateService {

    private ICurrentUrlStringBuilder urlStringBuilder;
    private ObjectMapper objectMapper;


    public CoinStatsCurrentRateService(ICurrentUrlStringBuilder urlStringBuilder, ObjectMapper objectMapper) {
        this.urlStringBuilder = urlStringBuilder;
        this.objectMapper = objectMapper;
    }

    /**
     * Retrieve current rate of the specified currency
     * @param currency the string representing a currency used to fetch the current rate
     * @return the current rate of the currency
     * @throws InvalidInputDataException if input or output data is incorrect
     */
    @Override
    public BigDecimal getRate(String currency) throws InvalidInputDataException {
        String url = urlStringBuilder.getUrl(currency);

        JsonNode mainJsonNode;
        try {
            mainJsonNode = objectMapper.readTree(new URL(url));
        } catch (IOException e) {
            throw new InvalidInputDataException("Przekazano błedne dane dane", e);
        }
        JsonNode result = mainJsonNode.get("coin");
        JsonNode jsonNode = result.get("price");
        return new BigDecimal(Optional.ofNullable(jsonNode)
                .orElseThrow()
                .asText());
    }
}
