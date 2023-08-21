package pl.kurs.bitcoindobijaczapp.services.servicesimpl;

import org.springframework.stereotype.Service;
import pl.kurs.bitcoindobijaczapp.enums.AssPainLevel;
import pl.kurs.bitcoindobijaczapp.exception.InvalidInputDataException;
import pl.kurs.bitcoindobijaczapp.model.TransferEvent;
import pl.kurs.bitcoindobijaczapp.services.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Service class for managing Bitcoin investments
 */
@Service
public class BitcoinService implements IBitcoinService {
    private ICurrentRateService rateService;
    private IInvestmentRateService pastRateService;
    private ITransferEventService transferEventService;
    private ISimpleService simpleService;
    private IAssPainService assPainService;



    public BitcoinService(ICurrentRateService rateService, IInvestmentRateService pastRateService,
                          ITransferEventService transferEventService, ISimpleService simpleService,
                          IAssPainService assPainService) {
        this.rateService = rateService;
        this.pastRateService = pastRateService;
        this.transferEventService = transferEventService;
        this.simpleService = simpleService;
        this.assPainService = assPainService;
    }

    /**
     * Invests in Bitcoin based on the specified investment parameters.
     * @param investmentDate date of the investment
     * @param currency which the investment is made
     * @param amount of  currency investment
     * @throws InvalidInputDataException if input data is invalid
     */

    @Override
    public void invest(String investmentDate, String currency, BigDecimal amount) throws InvalidInputDataException {

        if (investmentDate == null)
            throw new InvalidInputDataException("Data jest nullem!");
        if (currency == null)
            throw new InvalidInputDataException("Waluta jest nullem!");
        if (amount.doubleValue() <= 0)
            throw new InvalidInputDataException("Ilość musi być większ niż zero");


        LocalDate date = LocalDate.parse(investmentDate);
        BigDecimal pastRate = pastRateService.getRate(investmentDate, currency);
        BigDecimal currentRate = rateService.getRate(currency);
        BigDecimal amountOfBitcoin = simpleService.getAmountOfBtc(amount, pastRate);
        BigDecimal earningsInFiatCurrency = simpleService.getEarningsInFiatCurrency(amountOfBitcoin, currentRate);
        BigDecimal profitInFiatCurrency = simpleService.getProfitInFiatCurrency(earningsInFiatCurrency, amount);
        BigDecimal percentageProfit = simpleService.calculateProfitPercentage(profitInFiatCurrency, amount);
        AssPainLevel assPainLevel = assPainService.calculateAssPainLevel(profitInFiatCurrency);


        TransferEvent te = new TransferEvent(LocalDate.now(),date,
                amount, currency, amountOfBitcoin, pastRate, LocalDate.now(),
                profitInFiatCurrency, percentageProfit, currentRate, assPainLevel);
        transferEventService.saveEvent(te);
        printInfo(te);
    }


    private static void printInfo(TransferEvent transferEvent) {
        System.out.println("Kurs btc:" + transferEvent.getExchangeRateAtPurchaseDate());
        System.out.println("Ilość posiadanego btc:" + transferEvent.getAmountOfBtc());
        System.out.println("Procent zysku:" + transferEvent.getProfitPercentage());
        System.out.println("Zysk:" + transferEvent.getEarningsInCurrency());

    }
}
