package itsphere.dev.bookswap.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalException {
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseEntity<Object> handleCustomExeption(CustomException e) {
        return new ResponseEntity<>(e.getMessage(), e.getStatus());
    }
}
