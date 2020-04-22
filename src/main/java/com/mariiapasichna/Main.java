package com.mariiapasichna;

import com.mariiapasichna.api.UserApi;
import com.mariiapasichna.model.User;
import okhttp3.Response;

import java.io.IOException;

public class Main {

    public static final String URL = "http://localhost:" + System.getProperty("config") + "/Lesson_24_mariiapasichna/database/";
    public static final String PATH = "clear";

    public static void main(String[] args) {
        UserApi userApi = UserApi.getInstance();
        printResponse(userApi.createUser(new User("Kevin", 77)));
        printResponse(userApi.getListUsers());
        printResponse(userApi.updateUser(new User(37, "Kevin", 12)));
        printResponse(userApi.getUser("1"));
        printResponse(userApi.deleteUser(new User(7, "Kevin", 12)));
        printResponse(userApi.deleteAllUsers(PATH));
    }

    private static void printResponse(Response response) {
        try {
            System.out.println("Response code: " + response.code() + ". Response body: " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}