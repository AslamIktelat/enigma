package com.ai.enigma.enums;

public enum ContentType {
    TEXT("TEXT");


    private final String value;
    ContentType(String value) {
        this.value=value;
    }
    public String getTypeValue() {return value;}
}
