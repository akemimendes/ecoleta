package com.akemi.ecoleta.controller.exception;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handlerBussinessException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(Map.of("erro", ex.getMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handlerViolationDataException(DataIntegrityViolationException ex) {
        return ResponseEntity.badRequest().body(Map.of("erro", ex.getMessage()));

    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String, String>> handlerViolationDataException(BadCredentialsException ex) {
        var message = "O nome de usuário ou senha está incorreto";
        return ResponseEntity.badRequest().body(Map.of("erro", message));
    }

    @ExceptionHandler(AccountStatusException.class)
    public ResponseEntity<Map<String, String>> handlerViolationDataException(AccountStatusException dataException) {
        var message = "A conta está bloqueada";
        return ResponseEntity.badRequest().body(Map.of("erro", message));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, String>> handlerViolationDataException(AccessDeniedException dataException) {
        var message = "Você não está autorizado a acessar este recurso";
        return ResponseEntity.badRequest().body(Map.of("erro", message));
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Map<String, String>> handlerViolationDataException(ExpiredJwtException dataException) {
        var message = "O token JWT expirou";
        return ResponseEntity.badRequest().body(Map.of("erro", message));
    }

    // Erros de validação no corpo da requisição (ex: DTO com @Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }

    // Erros de validação em parâmetros de métodos (@RequestParam, @PathVariable)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getConstraintViolations().forEach(violation -> {
            String field = violation.getPropertyPath().toString();
            errors.put(field, violation.getMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }

    // Erros de regra de negócio ou validação personalizada
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Map<String, String>> handleCustomValidation(ValidationException ex) {
        return ResponseEntity.badRequest().body(Map.of("erro", ex.getMessage()));
    }

    // Erros genéricos não tratados
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("erro", "Erro inesperado: " + ex.getMessage()));
    }

}
