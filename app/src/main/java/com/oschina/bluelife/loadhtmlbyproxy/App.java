package com.oschina.bluelife.loadhtmlbyproxy;

import android.app.Application;

import com.oschina.bluelife.loadhtmlbyproxy.service.ProxyTaskService;

/**
 * Created by HiWin10 on 2016/9/23.
 */

public class App extends Application {
    private ProxyTaskService proxyTaskService;
    @Override
    public void onCreate() {
        super.onCreate();
        proxyTaskService=new ProxyTaskService();
    }
    public ProxyTaskService getProxyTaskService(){
        return proxyTaskService;
    }
}
