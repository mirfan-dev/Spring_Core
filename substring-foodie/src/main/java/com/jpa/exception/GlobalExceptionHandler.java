package com.jpa.exception;

import com.jpa.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

}
