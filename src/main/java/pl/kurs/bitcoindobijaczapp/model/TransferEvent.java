package pl.kurs.bitcoindobijaczapp.model;

import pl.kurs.bitcoindobijaczapp.enums.AssPainLevel;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * The TransferEvent  represents a financial transaction.
 */
@Entity
public class TransferEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOfCheck;
    private LocalDate purchaseDate;
    private BigDecimal investmentAmount;
    private String investmentCurrency;
    private BigDecimal amountOfBtc;
    private BigDecimal exchangeRateAtPurchaseDate;
    private LocalDate dateOfSale;
    private BigDecimal earningsInCurrency;
    private BigDecimal profitPercentage;
    private BigDecimal exchangeRateAtSale;
    @Enumerated(EnumType.STRING)
    private AssPainLevel assPainLevel;

    public TransferEvent() {
    }

    public TransferEvent(LocalDate dateOfCheck, LocalDate purchaseDate,
                         BigDecimal investmentAmount, String investmentCurrency,
                         BigDecimal amountOfBtc, BigDecimal exchangeRateAtPurchaseDate,
                         LocalDate dateOfSale, BigDecimal earningsInCurrency, BigDecimal profitPercentage,
                         BigDecimal exchangeRateAtSale, AssPainLevel assPainLevel) {
        this.dateOfCheck = dateOfCheck;
        this.purchaseDate = purchaseDate;
        this.investmentAmount = investmentAmount;
        this.investmentCurrency = investmentCurrency;
        this.amountOfBtc = amountOfBtc;
        this.exchangeRateAtPurchaseDate = exchangeRateAtPurchaseDate;
        this.dateOfSale = dateOfSale;
        this.earningsInCurrency = earningsInCurrency;
        this.profitPercentage = profitPercentage;
        this.exchangeRateAtSale = exchangeRateAtSale;
        this.assPainLevel = assPainLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfCheck() {
        return dateOfCheck;
    }

    public void setDateOfCheck(LocalDate dateOfCheck) {
        this.dateOfCheck = dateOfCheck;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(BigDecimal investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public String getInvestmentCurrency() {
        return investmentCurrency;
    }

    public void setInvestmentCurrency(String investmentCurrency) {
        this.investmentCurrency = investmentCurrency;
    }

    public BigDecimal getAmountOfBtc() {
        return amountOfBtc;
    }

    public void setAmountOfBtc(BigDecimal amountOfBtc) {
        this.amountOfBtc = amountOfBtc;
    }

    public BigDecimal getExchangeRateAtPurchaseDate() {
        return exchangeRateAtPurchaseDate;
    }

    public void setExchangeRateAtPurchaseDate(BigDecimal exchangeRateAtPurchaseDate) {
        this.exchangeRateAtPurchaseDate = exchangeRateAtPurchaseDate;
    }

    public LocalDate getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(LocalDate dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public BigDecimal getEarningsInCurrency() {
        return earningsInCurrency;
    }

    public void setEarningsInCurrency(BigDecimal profitInCurrency) {
        this.earningsInCurrency = profitInCurrency;
    }

    public BigDecimal getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(BigDecimal profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

    public BigDecimal getExchangeRateAtSale() {
        return exchangeRateAtSale;
    }

    public void setExchangeRateAtSale(BigDecimal exchangeRateAtSale) {
        this.exchangeRateAtSale = exchangeRateAtSale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferEvent that = (TransferEvent) o;
        return Objects.equals(id, that.id) && Objects.equals(dateOfCheck, that.dateOfCheck) &&
                Objects.equals(purchaseDate, that.purchaseDate) &&
                Objects.equals(investmentAmount, that.investmentAmount) &&
                Objects.equals(investmentCurrency, that.investmentCurrency) &&
                Objects.equals(amountOfBtc, that.amountOfBtc) &&
                Objects.equals(exchangeRateAtPurchaseDate, that.exchangeRateAtPurchaseDate) &&
                Objects.equals(dateOfSale, that.dateOfSale) &&
                Objects.equals(earningsInCurrency, that.earningsInCurrency) &&
                Objects.equals(profitPercentage, that.profitPercentage) &&
                Objects.equals(exchangeRateAtSale, that.exchangeRateAtSale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfCheck, purchaseDate, investmentAmount,
                investmentCurrency, amountOfBtc, exchangeRateAtPurchaseDate,
                dateOfSale, earningsInCurrency, profitPercentage, exchangeRateAtSale);
    }

    @Override
    public String toString() {
        return "TransferEvent{" +
                "id=" + id +
                ", dateOfCheck=" + dateOfCheck +
                ", purchaseDate=" + purchaseDate +
                ", investmentAmount=" + investmentAmount +
                ", investmentCurrency='" + investmentCurrency + '\'' +
                ", amountOfBtc=" + amountOfBtc +
                ", exchangeRateAtPurchaseDate=" + exchangeRateAtPurchaseDate +
                ", dateOfSale=" + dateOfSale +
                ", profitInCurrency=" + earningsInCurrency +
                ", profitPercentage=" + profitPercentage +
                ", exchangeRateAtSale=" + exchangeRateAtSale +
                '}';
    }
}
