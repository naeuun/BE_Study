package com.ll.demo03.global.exceptionHandlers;

import com.ll.demo03.global.exceptions.GlobalException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(Exception ex) {
        log.debug("hadleException 1");
        return ex.getMessage();
    }

    @ExceptionHandler(GlobalException.class)
    @ResponseBody
    public String handleGlobalException(Exception ex) {
        log.debug("hadleException 2");
        return ex.getMessage();
    }
}
