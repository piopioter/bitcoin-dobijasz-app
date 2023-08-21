package pl.kurs.bitcoindobijaczapp.config;

public interface AppConfig {

    //https://api.coindesk.com/v1/bpi/historical/close.json?start=2012-02-09&end=2022-07-10&currency=PLN
    String COINDESK_APP = "https://api.coindesk.com";
    String COINDESK_ENDPOINT = "/v1/bpi/historical/close.json";
    String COINDESK_DATE_QUERY = "?start=";
    String COINDESK_CURRENCY_QUERY = "&end=2022-07-10&currency=";


    //https://api.coinstats.app/public/v1/coins/bitcoin?currency=PLN

    String COINSTATS_APP = "https://api.coinstats.app";
    String COINSTATS_ENDPOINT = "/public/v1/coins/bitcoin";
    String COINSTATS_CURRENCY_QUERY = "?currency=";


}