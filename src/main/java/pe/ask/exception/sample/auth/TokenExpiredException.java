package pe.ask.exception.sample.auth;

import pe.ask.exception.core.annotation.ExceptionDef;
import pe.ask.exception.core.catalog.auth.AuthErrorCatalog;
import pe.ask.exception.core.model.BaseException;

/**
 * Exception thrown when the authentication token provided by the client has expired.
 */
@ExceptionDef(AuthErrorCatalog.class)
public class TokenExpiredException extends BaseException {

    /**
     * Constructs a new TokenExpiredException resolving its default properties from {@link AuthErrorCatalog}.
     */
    public TokenExpiredException() {
        super();
    }

    /**
     * Creates a builder to construct a customized {@link TokenExpiredException}.
     *
     * @return A builder instance.
     */
    public static Builder<TokenExpiredException> builder() {
        return new Builder<>(TokenExpiredException.class);
    }
}
