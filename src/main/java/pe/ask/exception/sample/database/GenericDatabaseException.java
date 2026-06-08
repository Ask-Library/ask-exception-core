package pe.ask.exception.sample.database;

import pe.ask.exception.core.annotation.ExceptionDef;
import pe.ask.exception.core.catalog.database.DatabaseErrorCatalog;
import pe.ask.exception.core.model.BaseException;

/**
 * Exception thrown when a generic error occurs while accessing or modifying the database.
 */
@ExceptionDef(DatabaseErrorCatalog.class)
public class GenericDatabaseException extends BaseException {

    /**
     * Constructs a new GenericDatabaseException resolving its default properties from {@link DatabaseErrorCatalog}.
     */
    public GenericDatabaseException() {
        super();
    }

    /**
     * Creates a builder to construct a customized {@link GenericDatabaseException}.
     *
     * @return A builder instance.
     */
    public static Builder<GenericDatabaseException> builder() {
        return new Builder<>(GenericDatabaseException.class);
    }
}
