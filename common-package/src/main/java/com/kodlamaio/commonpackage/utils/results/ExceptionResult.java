package com.kodlamaio.commonpackage.utils.results;

import java.time.LocalDateTime;

public class ExceptionResult<T> {
    private LocalDateTime timestamp;
    private String type;
    private T message;

    public ExceptionResult(String type, T message) {
        timestamp = LocalDateTime.now();
        this.type = type;
        this.message = message;
    }
}
