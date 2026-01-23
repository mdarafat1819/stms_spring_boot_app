package com.example.stms;

public enum Status {
    PENDING("Task is pending"), 
    IN_PROGRESS("Task in progress"), 
    DONE("Task is completed");

    private String description;

    Status(){}
    Status(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

}
