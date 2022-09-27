package com.example.registrationrestapi.Model;

public class ResponseModel
{
    int id;
    String token;

    public ResponseModel() {
    }

    public ResponseModel(int id, String token) {
        this.id = id;
        this.token = token;
    }

    public String getId() {
        return String.valueOf(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
