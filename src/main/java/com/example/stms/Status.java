package com.example.stms;

public enum Status {
    PENDING, IN_PROGRESS, DONE;

    private String description;

    Status(){}
    Status(String description) {
        this.description = description;
    }
    String getDescription() {
        return description;
    }

}
