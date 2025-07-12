package com.nsl.kafka.dataMigSync;

public class NoRecordsFoundException extends RuntimeException{
    public NoRecordsFoundException(String s) {
        super(s);
    }
}