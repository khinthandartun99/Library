package com.example.myapp.Api;

public class ApiUtils {

    public static final String BASE_URL="http://192.168.43.99/CULibrary/api/";

    public static Apiinterface getApi(){
        return ApiClient.getRetrofit(BASE_URL).create(Apiinterface.class);
    }
}
