package ru.geekbrains.lesson6;


import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class Weather1 {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("www.accuweather.com")
                .addPathSegment("/en/ru/moscow/294021/daily-weather-forecast/294021")
                .build();

        String WeatherBody = "{\n" +
                "    \"Date\" : \"2022-06-19T07:00:00+03:00\",\n" +
                "    \"EpochDate\" : \"1655611200\",\n" +
                "}";
        RequestBody requestWeatherBody = RequestBody.create(WeatherBody, MediaType.parse("JSON"));
        Request requestweatherBody = new Request.Builder()
                .url(httpUrl)
                .addHeader("Content-Type", "application/json")
                .post(requestWeatherBody)
                .build();

        Response responseAuth = okHttpClient.newCall(requestweatherBody).execute(); {

            System.out.println(responseAuth.isSuccessful());
        }


    }
}