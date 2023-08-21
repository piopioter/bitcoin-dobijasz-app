package pl.kurs.bitcoindobijaczapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kurs.bitcoindobijaczapp.exception.InvalidInputDataException;
import pl.kurs.bitcoindobijaczapp.services.IBitcoinService;

import java.math.BigDecimal;

import java.util.Scanner;

/**
 * The main  class for the Bitcoin Dobijacz application
 * @author piotr cz
 * @version 1.0.0
 */
@SpringBootApplication
public class BitcoinDobijaczAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(BitcoinDobijaczAppApplication.class, args);
        IBitcoinService bean = ctx.getBean(IBitcoinService.class);
        Scanner scanner = new Scanner(System.in);

        int option = -1;
        do {
            try {
                printMenu();
                switch (option = scanner.nextInt()) {
                    case 1:
                        scanner.nextLine();
                        System.out.println("Podaj datę zakupu BTC, przykładowy wzór -> \"yyyy-MM-dd\"");
                        String date = scanner.nextLine();
                        System.out.println("W jakiej walucie chcesz zakupic?");
                        String currency = scanner.nextLine();
                        System.out.println("Za jaką ilość chcesz zakupić?");
                        BigDecimal amount = scanner.nextBigDecimal();
                        bean.invest(date, currency, amount);
//                        System.out.println("Kurs btc:" + transferEvent.getExchangeRateAtPurchaseDate());
//                        System.out.println("Ilość posiadanego btc:" + transferEvent.getAmountOfBtc());
//                        System.out.println("Procent zysku:" + transferEvent.getProfitPercentage());
//                        System.out.println("Zysk:" + transferEvent.getEarningsInCurrency());
                        break;
                    case 0:
                        System.out.println("Koniec");
                        break;
                }
            } catch (InvalidInputDataException e) {
                e.printStackTrace();
            }
        } while (option != 0);

        scanner.close();

    }

    private static void printMenu() {
        System.out.println("Inwestycja -> 1");
        System.out.println("Koniec -> 0");

    }

}
