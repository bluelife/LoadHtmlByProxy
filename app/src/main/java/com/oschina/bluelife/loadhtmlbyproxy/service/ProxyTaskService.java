package com.oschina.bluelife.loadhtmlbyproxy.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HiWin10 on 2016/9/23.
 */

public class ProxyTaskService {
    public static String BASE_URL="http://api.shengzhihang.com";
    private ProxyApi proxyApi;
    private JSApi jsApi;

    public ProxyTaskService(){
        this(BASE_URL);
    }
    public ProxyTaskService(String url){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        proxyApi = retrofit.create(ProxyApi.class);
        jsApi=retrofit.create(JSApi.class);
    }
    public ProxyApi getProxyApi(){
        return proxyApi;
    }
    public JSApi getJsApi(){
        return jsApi;
    }
}
