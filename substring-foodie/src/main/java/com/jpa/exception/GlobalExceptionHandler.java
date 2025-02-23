package com.jpa.exception;

import com.jpa.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


        @ExceptionHandler(value = MethodArgumentNotValidException.class)
        public ResponseEntity<Object> methodArgException(MethodArgumentNotValidException ex){
            Map<String,String> errorMap=new HashMap<>();
            ex.getFieldErrors().stream().forEach((error)->errorMap.put(error.getField(),error.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
        }


        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ErrorResponse> errorResponseHandler(ResourceNotFoundException ex) {
            ErrorResponse errorResponse=ErrorResponse.builder()
                    .message(ex.getMessage())
                    .status(HttpStatus.NOT_FOUND) // Use NOT_FOUND for ResourceNotFoundException
                    .build();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse); // Cleaner response creation
        }

    @ExceptionHandler(InvalidFilePathException.class)
    public ResponseEntity<ErrorResponse> errorResponseHandler(InvalidFilePathException ex) {
        ErrorResponse errorResponse=ErrorResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND) // Use NOT_FOUND for ResourceNotFoundException
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse); // Cleaner response creation
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentialsException(BadCredentialsException ex) {
        ErrorResponse errorResponse=ErrorResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST) // Use NOT_FOUND for ResourceNotFoundException
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse); // Cleaner response creation
    }

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(DisabledException ex) {
        ErrorResponse errorResponse=ErrorResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST) // Use NOT_FOUND for ResourceNotFoundException
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse); // Cleaner response creation
    }

}
