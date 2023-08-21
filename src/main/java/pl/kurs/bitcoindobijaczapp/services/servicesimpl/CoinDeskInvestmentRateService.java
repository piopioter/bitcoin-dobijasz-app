package pl.kurs.bitcoindobijaczapp.services.servicesimpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.kurs.bitcoindobijaczapp.exception.InvalidInputDataException;
import pl.kurs.bitcoindobijaczapp.services.IInvestmentRateService;
import pl.kurs.bitcoindobijaczapp.services.IUrlStringBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Optional;

/**
 * This class retrieve the past rate of specified crypto from JSON
 */

@Service
public class CoinDeskInvestmentRateService implements IInvestmentRateService {
    private IUrlStringBuilder urlStringBuilder;
    private ObjectMapper objectMapper;

    public CoinDeskInvestmentRateService(IUrlStringBuilder urlStringBuilder, ObjectMapper objectMapper) {
        this.urlStringBuilder = urlStringBuilder;
        this.objectMapper = objectMapper;
    }

    /**
     * Retrieve past rate of the specified currency
     * @param investmentDate historical date
     * @param currency the string representing a currency used to fetch the past rate
     * @return the past rate of currency
     * @throws InvalidInputDataException if input or output data is incorrect
     */
    @Override
    public BigDecimal getRate(String investmentDate, String currency) throws InvalidInputDataException {
        String url = urlStringBuilder.getUrl(currency, investmentDate);

        JsonNode mainJsonNode;
        try {
            mainJsonNode = objectMapper.readTree(new URL(url));
        } catch (IOException e) {
            throw new InvalidInputDataException("Przekazano błedne dane", e);
        }
        JsonNode jsonNode = mainJsonNode.get("bpi");
        JsonNode result = jsonNode.get(investmentDate);

        return new BigDecimal(Optional.ofNullable(result)
                .orElseThrow()
                .asText());

    }
}
