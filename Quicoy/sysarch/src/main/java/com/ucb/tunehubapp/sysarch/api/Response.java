package com.ucb.tunehubapp.sysarch.api;

public class Response {
    private String message;
    private Object data;

    public Response(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public Response() {

    }

    public String getMessage(){

        return message;
    }
    public void SetMessage(String message){

        this.message = message;
    }
    public String getData(){

        return null;
    }
    public void SetData(String data){

        this.data = data;
    }
}
