package com.youkeda.vhr2.exception;


import com.youkeda.vhr2.model.ResponseBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLException.class)
    public ResponseBean sqlException(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return ResponseBean.error("该数据有关联数据，操作失败!");
        }
        return ResponseBean.error("数据库异常，操作失败!");
    }
}