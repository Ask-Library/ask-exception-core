package pe.ask.exception.sample.auth;

import pe.ask.exception.core.annotation.ExceptionDef;
import pe.ask.exception.core.catalog.auth.AuthErrorCatalog;
import pe.ask.exception.core.model.BaseException;

/**
 * Exception thrown when a user is authenticated but does not have the required 
 * permissions to access a specific resource.
 */
@ExceptionDef(AuthErrorCatalog.class)
public class ForbiddenException extends BaseException {

    /**
     * Constructs a new ForbiddenException resolving its default properties from {@link AuthErrorCatalog}.
     */
    public ForbiddenException() {
        super();
    }

    /**
     * Creates a builder to construct a customized {@link ForbiddenException}.
     *
     * @return A builder instance.
     */
    public static Builder<ForbiddenException> builder() {
        return new Builder<>(ForbiddenException.class);
    }
}
