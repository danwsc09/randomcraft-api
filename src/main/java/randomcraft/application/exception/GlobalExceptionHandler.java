package randomcraft.application.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleBadRequest(Exception ex, HttpServletRequest request) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, "Bad request: " + ex.getMessage(),
                request.getRequestURI(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler({InvalidRandomcraftMatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleInvalidRandomcraftMatch(Exception ex, HttpServletRequest request) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, "Invalid match data: " + ex.getMessage(),
                request.getRequestURI(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler({NoSuchElementException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNotFound(Exception ex, HttpServletRequest request) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, "Not found: " + ex.getMessage(),
                request.getRequestURI(), HttpStatus.NOT_FOUND.value());
    }
}
