package blogs.bisa.com.bo.application.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author aCallejas
 */
@Data
public class ExceptionResponse {

    private String message;
    private List<String> details;

    public ExceptionResponse(String message) {
        this.message = message;
    }

    public ExceptionResponse(String message, List<String> details) {
        this.message = message;
        this.details = details;
    }
}
