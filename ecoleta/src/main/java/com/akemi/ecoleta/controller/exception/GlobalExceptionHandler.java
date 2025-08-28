package com.akemi.ecoleta.controller.exception;

import java.nio.file.AccessDeniedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.ExpiredJwtException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handlerBussinessException(IllegalArgumentException bussinessException) {
        var message = "Argumento inválido";
        logger.error(message, bussinessException);
        return new ResponseEntity<>(message, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handlerViolationDataException(DataIntegrityViolationException dataException) {
        var message = "Violação de dados";
        logger.error(message, dataException);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handlerViolationDataException(BadCredentialsException dataException) {
        var message = "O nome de usuário ou senha está incorreto";
        logger.error(message, dataException);
        return new ResponseEntity<>(message, HttpStatusCode.valueOf(401));
    }

    @ExceptionHandler(AccountStatusException.class)
    public ResponseEntity<String> handlerViolationDataException(AccountStatusException dataException) {
        var message = "A conta está bloqueada";
        logger.error(message, dataException);
        return new ResponseEntity<>(message, HttpStatusCode.valueOf(403));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handlerViolationDataException(AccessDeniedException dataException) {
        var message = "Você não está autorizado a acessar este recurso";
        logger.error(message, dataException);
        return new ResponseEntity<>(message, HttpStatusCode.valueOf(403));
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<String> handlerViolationDataException(ExpiredJwtException dataException) {
        var message = "O token JWT expirou";
        logger.error(message, dataException);
        return new ResponseEntity<>(message, HttpStatusCode.valueOf(403));
    }

}
