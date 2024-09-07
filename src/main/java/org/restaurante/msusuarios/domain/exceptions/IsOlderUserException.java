package org.restaurante.msusuarios.domain.exceptions;

import static org.restaurante.msusuarios.domain.util.Constants.IS_OLDER_MESSAGE;

public class IsOlderUserException extends RuntimeException{
    public IsOlderUserException() {
        super(IS_OLDER_MESSAGE);
    }
}
