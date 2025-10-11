package com.fiec.estoqueback.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Captura e loga exceções gerais de forma centralizada.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex) {

        // Log da Exceção em um Único Ponto
        // O uso de ex.getMessage() e ex, garante o log da stack trace.
        log.error("******** EXCEÇÃO GLOBAL CAPTURADA ********");
        log.error("Mensagem: {}", ex.getMessage(), ex);
        log.error("******************************************");

        // Cria o corpo da resposta HTTP (JSON)
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Internal Server Error");
        body.put("message", "Ocorreu um erro inesperado no servidor. Por favor, tente novamente.");

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Você pode adicionar mais @ExceptionHandler para tipos específicos de exceção (ex: NotFoundException)
}