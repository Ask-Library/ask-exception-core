package pe.ask.exception.sample.auth;

import pe.ask.exception.core.annotation.ExceptionDef;
import pe.ask.exception.core.catalog.auth.AuthErrorCatalog;
import pe.ask.exception.core.model.BaseException;

/**
 * Exception thrown when the credentials (e.g. username and password) provided by the user are incorrect.
 */
@ExceptionDef(AuthErrorCatalog.class)
public class InvalidCredentialsException extends BaseException {

    /**
     * Constructs a new InvalidCredentialsException resolving its default properties from {@link AuthErrorCatalog}.
     */
    public InvalidCredentialsException() {
        super();
    }

    /**
     * Creates a builder to construct a customized {@link InvalidCredentialsException}.
     *
     * @return A builder instance.
     */
    public static Builder<InvalidCredentialsException> builder() {
        return new Builder<>(InvalidCredentialsException.class);
    }
}
