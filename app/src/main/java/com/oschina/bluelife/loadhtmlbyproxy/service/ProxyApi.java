package com.oschina.bluelife.loadhtmlbyproxy.service;

import com.oschina.bluelife.loadhtmlbyproxy.model.ProxyInfo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by HiWin10 on 2016/9/23.
 */

public interface ProxyApi {
    @GET("/task/list")
    Call<ProxyInfo> loadProxyInfo();
}
