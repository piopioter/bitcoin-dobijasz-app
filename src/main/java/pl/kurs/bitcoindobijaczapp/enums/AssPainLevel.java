package pl.kurs.bitcoindobijaczapp.enums;

public enum AssPainLevel {
    NO_PAIN("Ból dupy  nieobecny."),
    MILD("Ból dupy znikomy"),
    MODERATE("Ból dupy na akceptowalnym poziomie"),
    SEVERE("Ból dupt jest duży potrzebna maść"),
    VERY_SEVERE("Ból dupy do  wytzymania,  potrzebne  wiadro maści "),
    WORST_PAIN("Ból dupy jest ogromy, nawet maść nie pomoże ");

    private String description;

    AssPainLevel(String description) {
        this.description = description;
    }
}
