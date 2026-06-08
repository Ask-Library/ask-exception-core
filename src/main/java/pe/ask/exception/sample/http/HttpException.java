package pe.ask.exception.sample.http;

import pe.ask.exception.core.annotation.ExceptionDef;
import pe.ask.exception.core.catalog.http.HttpErrorCatalog;
import pe.ask.exception.core.model.BaseException;

/**
 * Exception thrown when a generic HTTP error occurs during the processing of a request.
 */
@ExceptionDef(HttpErrorCatalog.class)
public class HttpException extends BaseException {

    /**
     * Constructs a new HttpException resolving its default properties from {@link HttpErrorCatalog}.
     */
    public HttpException() {
        super();
    }

    /**
     * Creates a builder to construct a customized {@link HttpException}.
     *
     * @return A builder instance.
     */
    public static Builder<HttpException> builder() {
        return new Builder<>(HttpException.class);
    }
}
