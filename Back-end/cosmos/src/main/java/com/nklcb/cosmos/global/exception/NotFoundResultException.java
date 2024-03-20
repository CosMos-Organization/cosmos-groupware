package com.nklcb.cosmos.global.exception;

public class NotFoundResultException extends IllegalStateException {
    private static final String MESSAGE = "검색한 결과가 존재하지 않습니다.";

    public NotFoundResultException() {
        super(MESSAGE);
    }
}