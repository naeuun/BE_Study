package com.ll.demo03.global.exceptionHandlers;

import com.ll.demo03.global.exceptions.GlobalException;
import com.ll.demo03.global.rsData.RsData;
import com.ll.demo03.standard.dto.Empty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(GlobalException.class)
    @ResponseBody
    public ResponseEntity<RsData<Empty>> handleException(GlobalException ex) {
        RsData<Empty> rsData = ex.getRsData();

        return ResponseEntity
                .status(rsData.getStatusCode())
                .body(rsData);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<RsData<Empty>> handleException(MethodArgumentNotValidException ex) {
        String resultCode = "400-" + ex.getBindingResult().getFieldError().getCode();
        String msg = ex.getBindingResult().getFieldError().getField() + " : " + ex.getBindingResult().getFieldError().getDefaultMessage();

        return handleException(
                new GlobalException(
                        resultCode,
                        msg
                )
        );
    }
}
