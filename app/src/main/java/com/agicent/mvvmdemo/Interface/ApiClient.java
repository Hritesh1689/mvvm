package com.agicent.mvvmdemo.Interface;

import android.content.Context;
import android.content.SharedPreferences;

import com.agicent.mvvmdemo.utils.ConstantUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Context mContext;
    public static Retrofit retrofit = null;
    private static SharedPreferences sharedPrefer;
    private static String auth_key;

    static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    /*
   retrofit Instance without any permissions that will be
       used by get_api_access_token API
    */
    public static Retrofit getAccessClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ConstantUtils.base_url)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okAccessClient())
                    .build();
        }
        return retrofit;
    }

    /*
    getting http client
    */
    public static OkHttpClient okAccessClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    public static Retrofit getRetrofitInstanceRestApi(Context context) {

        sharedPrefer = context.getSharedPreferences(ConstantUtils.prefer_name, Context.MODE_PRIVATE);
        //auth_key = sharedPrefer.getString(ConstantUtils.auth_token, "");
        auth_key="068cf2fcc58a8b91fd03faad5e6dc885";

         OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .addHeader("Auth-Token", auth_key)
                        .build();

                return chain.proceed(request);
            }
        }).connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);

        OkHttpClient client = httpClient.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(ConstantUtils.base_url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        return retrofit;
    }

    public static Retrofit getRxjavaInstanceRestApi(Context context) {

        sharedPrefer = context.getSharedPreferences(ConstantUtils.prefer_name, Context.MODE_PRIVATE);
        //auth_key = sharedPrefer.getString(ConstantUtils.auth_token, "");
        auth_key="068cf2fcc58a8b91fd03faad5e6dc885";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .addHeader("Auth-Token", auth_key)

                        .build();

                return chain.proceed(request);
            }
        }).connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);

        OkHttpClient client = httpClient.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(ConstantUtils.base_url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
}
