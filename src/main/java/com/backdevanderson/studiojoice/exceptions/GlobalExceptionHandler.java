package com.backdevanderson.studiojoice.exceptions;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ResponseError> recursoNaoEncontrado(ResourceNotFound e, HttpServletRequest request){
        ResponseError error = new ResponseError();
        error.setTimestamp(LocalDateTime.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setErro("Recurso não encontrado");
        error.setMsg(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    // qualquer outro erro 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> tratarErroGeral(Exception ex, WebRequest request) {
        ResponseError erro = new ResponseError(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Erro interno no servidor: " ,
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
