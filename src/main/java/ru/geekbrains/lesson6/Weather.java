package ru.geekbrains.lesson6;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class Weather {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        String createWeatherJson = "{\n" +
                "    \"id\" : \"3546\",\n" +
                "    \"key\" : \"1\",\n" +
                "}";

        RequestBody requestCreateWeatherBody = RequestBody.create(createWeatherJson, MediaType.parse("JSON"));

        Request requestCreateWeather = new Request.Builder()
                .url("https://www.gismeteo.ru/weather-taganrog-5106/")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .post(requestCreateWeatherBody)
                .build();

        Response createWeatherResponse = okHttpClient.newCall(requestCreateWeather).execute();

        System.out.println(createWeatherResponse.body().string());
    }
}