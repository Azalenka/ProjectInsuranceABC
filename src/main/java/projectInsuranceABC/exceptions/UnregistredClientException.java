package projectInsuranceABC.exceptions;

/**
 * Исключение незарегистрированного клиента
 */
public class UnregistredClientException extends Exception {
    /**
     * Конструктор без параметров
     */
    public UnregistredClientException() {
        super();
    }

    /**
     * Конструктор с информационным сообщением
     *
     * @param message информационное сообщение
     */
    public UnregistredClientException(String message) {
        super(message);
    }
}
