package com.example.demo.api.model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultMessage {
    private String successYn;
    private HttpStatus statusCode;
    private String code; // 업무성 코드
    private Object data;  // 데이터 객체
    private String message;
    private String devMessage;


    public ResultMessage() {
    }

    public ResultMessage(String successYn) {
        this.successYn = successYn;
        this.statusCode = null;
        this.message = null;
        this.devMessage = null;
    }
    public ResultMessage(String successYn, String message) {
        this.successYn = successYn;
        this.statusCode = null;
        this.message = message;
        this.devMessage = null;
    }
    public ResultMessage(String successYn, String message, HttpStatus statusCode) {
        this.successYn = successYn;
        this.statusCode = statusCode;
        this.message = message;
        this.devMessage = null;
    }
    
    public ResultMessage(String successYn, String message, HttpStatus statusCode, String code) {
        this.successYn = successYn;
        this.statusCode = statusCode;
        this.code = code;
        this.data = null;
        this.message = message;    
        this.devMessage = null;
    }
     
    public ResultMessage(String successYn, String code, Object data, String message) {
        this.successYn = successYn;
        this.statusCode = null;
        this.code = code;
        this.data = data;
        this.message = message;    
        this.devMessage = null;
    }

    public ResultMessage(String successYn, String message, HttpStatus statusCode, Object data) {
        this.successYn = successYn;
        this.statusCode = statusCode;
        this.data = data;
        this.message = message;    
        this.devMessage = null;
    }

}
