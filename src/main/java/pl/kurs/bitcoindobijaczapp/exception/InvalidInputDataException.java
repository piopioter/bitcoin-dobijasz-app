package pl.kurs.bitcoindobijaczapp.exception;

public class InvalidInputDataException extends Exception {
    public InvalidInputDataException(String message) {
        super(message);
    }

    public InvalidInputDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
