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
    private static OkHttpClient client = new OkHttpClient().newBuilder().build();
    private static MediaType mediaType = MediaType.parse("application/json");
    private static Gson gson = new Gson();
    private static String url = Main.URL;

    public static void deleteAllUsers(String path) throws IOException {
        Request request = new Request.Builder()
                .url(url + path)
                .delete()
                .addHeader("Accept", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

    public static void deleteUser(User user) throws IOException {
        RequestBody body = RequestBody.create(gson.toJson(user), mediaType);
        Request request = new Request.Builder()
                .url(url)
                .delete(body)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

    public static void getUser(String id) throws IOException {
        Request request = new Request.Builder()
                .url(url + "/" + id)
                .get()
                .addHeader("Accept", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

    public static void updateUser(User user) throws IOException {
        RequestBody body = RequestBody.create(gson.toJson(user), mediaType);
        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

    public static void getListUsers() throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Accept", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

    public static void createUser(User user) throws IOException {
        RequestBody body = RequestBody.create(gson.toJson(user), mediaType);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}