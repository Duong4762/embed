package com.example.demo.enums;

public enum LogType {
    BARRIER_DOWN("Hạ rào"),

    BARRIER_UP("Nâng rào");

    private String message;

    LogType(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
