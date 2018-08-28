package ar.com.tecnosoftware.somos.cliente.exception;

public class ClienteNotFoundException extends Exception {

    public ClienteNotFoundException() {
    }

    public ClienteNotFoundException(String message) {
        super(message);
    }
}
