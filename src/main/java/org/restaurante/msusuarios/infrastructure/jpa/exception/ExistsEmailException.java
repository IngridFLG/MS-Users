package org.restaurante.msusuarios.infrastructure.jpa.exception;

import static org.restaurante.msusuarios.infrastructure.configuration.Constants.EMAIL_MESSAGE;

public class ExistsEmailException extends RuntimeException {
    public ExistsEmailException() {
        super(EMAIL_MESSAGE);
    }
}
