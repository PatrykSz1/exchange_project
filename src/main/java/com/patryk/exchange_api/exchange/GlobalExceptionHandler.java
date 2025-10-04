package com.patryk.exchange_api.exchange;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExchangeBadRequestException.class)
    public ResponseEntity<ExceptionDto> handleBadRequest(ExchangeBadRequestException ex,
                                                         HttpServletRequest httpServletRequest) {

        ExceptionDto exceptionDto = ExceptionDto.builder()
                .timeStamp(Instant.now().toString())
                .error("Bad Request")
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .path(httpServletRequest.getRequestURI())
                .build();

        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MailSendFailedException.class)
    public ResponseEntity<ExceptionDto> handleMail(MailSendFailedException ex, HttpServletRequest httpServletRequest) {

        ExceptionDto exceptionDto = ExceptionDto.builder()
                .timeStamp(Instant.now().toString())
                .error("Bad Gateway")
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .path(httpServletRequest.getRequestURI())
                .build();

        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}

