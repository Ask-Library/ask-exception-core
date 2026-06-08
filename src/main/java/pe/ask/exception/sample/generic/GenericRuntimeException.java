package pe.ask.exception.sample.generic;

import pe.ask.exception.core.annotation.ExceptionDef;
import pe.ask.exception.core.catalog.generic.GenericRuntimeErrorCatalog;
import pe.ask.exception.core.model.BaseException;

/**
 * Exception thrown when an unexpected or uncategorized runtime error occurs.
 */
@ExceptionDef(GenericRuntimeErrorCatalog.class)
public class GenericRuntimeException extends BaseException {

    /**
     * Constructs a new GenericRuntimeException resolving its default properties from {@link GenericRuntimeErrorCatalog}.
     */
    public GenericRuntimeException() {
        super();
    }

    /**
     * Creates a builder to construct a customized {@link GenericRuntimeException}.
     *
     * @return A builder instance.
     */
    public static Builder<GenericRuntimeException> builder() {
        return new Builder<>(GenericRuntimeException.class);
    }
}
