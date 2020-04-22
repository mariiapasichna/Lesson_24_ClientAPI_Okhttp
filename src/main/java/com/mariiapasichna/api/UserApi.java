package com.mariiapasichna.api;

import com.google.gson.Gson;
import com.mariiapasichna.Main;
import com.mariiapasichna.model.User;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class UserApi {
    private static UserApi instance;
    private MediaType mediaType = MediaType.parse("application/json");
    private Gson gson = new Gson();
    private String url = Main.URL;

    public static synchronized UserApi getInstance() {
        if (instance == null) {
            instance = new UserApi();
        }
        return instance;
    }

    private UserApi() {
    }

    private Response getResponse(String method, RequestBody body, String url) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .method(method, body)
                    .addHeader("Accept", "application/json")
                    .build();
            return client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Response createUser(User user) {
        RequestBody body = RequestBody.create(gson.toJson(user), mediaType);
        return getResponse("POST", body, url);
    }

    public Response getUser(String path) {
        return getResponse("GET", null, url + path);
    }

    public Response getListUsers() {
        return getResponse("GET", null, url);
    }

    public Response updateUser(User user) {
        RequestBody body = RequestBody.create(gson.toJson(user), mediaType);
        return getResponse("PUT", body, url);
    }

    public Response deleteUser(User user) {
        RequestBody body = RequestBody.create(gson.toJson(user), mediaType);
        return getResponse("DELETE", body, url);
    }

    public Response deleteAllUsers(String path) {
        return getResponse("DELETE", null, url + path);
    }
}