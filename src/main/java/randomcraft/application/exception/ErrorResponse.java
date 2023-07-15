package randomcraft.application.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
public class ErrorResponse {

    private int status;
    private int code;
    private String message;
    private String error;
    private String path;
    private String timestamp;

    public ErrorResponse(HttpStatus httpStatus, String message, String path, int code) {
        this.timestamp = new Date().toString();
        this.error = httpStatus.getReasonPhrase();
        this.status = httpStatus.value();
        this.message = message;
        this.path = path;
        this.code = code;
    }
}
