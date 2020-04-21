package com.mariiapasichna;

import com.mariiapasichna.api.UserApi;
import com.mariiapasichna.model.User;

import java.io.IOException;

public class Main {

    public static final String URL = "http://localhost:" + System.getProperty("config") + "/Lesson_24_mariiapasichna/database";
    public static final String PATH = "/clear";

    public static void main(String[] args) {
        try {
            UserApi.createUser(new User("Kevin", 77));
            UserApi.getListUsers();
            UserApi.updateUser(new User(37, "Kevin", 12));
            UserApi.getUser("1");
            UserApi.deleteUser(new User(7, "Kevin", 12));
            //UserApi.deleteAllUsers(PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}