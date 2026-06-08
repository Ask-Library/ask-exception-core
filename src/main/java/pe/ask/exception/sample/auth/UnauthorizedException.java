package pe.ask.exception.sample.auth;

import pe.ask.exception.core.annotation.ExceptionDef;
import pe.ask.exception.core.catalog.auth.AuthErrorCatalog;
import pe.ask.exception.core.model.BaseException;

/**
 * Exception thrown when authentication is required but missing or invalid for a specific resource.
 */
@ExceptionDef(AuthErrorCatalog.class)
public class UnauthorizedException extends BaseException {

    /**
     * Constructs a new UnauthorizedException resolving its default properties from {@link AuthErrorCatalog}.
     */
    public UnauthorizedException() {
        super();
    }

    /**
     * Creates a builder to construct a customized {@link UnauthorizedException}.
     *
     * @return A builder instance.
     */
    public static Builder<UnauthorizedException> builder() {
        return new Builder<>(UnauthorizedException.class);
    }
}
