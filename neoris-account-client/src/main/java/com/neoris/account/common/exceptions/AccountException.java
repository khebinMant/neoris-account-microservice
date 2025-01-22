package com.neoris.account.common.exceptions;

/**
 * Exception for bussiness logic exceptions
 *
 * @author Kevin
 * @version 1.0
 */
public class AccountException extends RuntimeException {


    /**
     * Constructor
     */
    public AccountException() {
        super();
    }

    /**
     * Constructor
     *
     * @param message Message
     * @param cause Cause
     */
    public AccountException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor
     *
     * @param message Message
     */
    public AccountException(String message) {
        super(message);
    }

}
