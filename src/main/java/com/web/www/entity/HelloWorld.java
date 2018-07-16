package com.web.www.entity;

public class HelloWorld {

    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void printMessage(){
        System.out.println("[WebDemo]:Message from class  +"+message);
    }
}
