package com.oschina.bluelife.loadhtmlbyproxy.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by HiWin10 on 2016/9/23.
 */

public interface JSApi {
    @GET
    Call<ResponseBody> loadInjectJS(@Url String url);
}
