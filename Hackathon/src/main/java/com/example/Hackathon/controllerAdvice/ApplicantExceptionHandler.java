package com.example.Hackathon.controllerAdvice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApplicantExceptionHandler {
    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<?> handleException(Exception e){
        Map<String, String> response=new HashMap<>();
        response.put("cause",e.getCause().toString());
        response.put("message",e.getMessage());
        return Mono.just(response);
    }
}
