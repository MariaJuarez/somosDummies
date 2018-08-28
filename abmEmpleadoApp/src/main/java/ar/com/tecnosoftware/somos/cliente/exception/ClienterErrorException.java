package ar.com.tecnosoftware.somos.cliente.exception;

public class ClienterErrorException extends Exception {

    public ClienterErrorException() {
    }

    public ClienterErrorException(String message) {
        super(message);
    }
}
