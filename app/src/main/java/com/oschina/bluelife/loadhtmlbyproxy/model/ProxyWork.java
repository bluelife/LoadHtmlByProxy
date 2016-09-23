package com.oschina.bluelife.loadhtmlbyproxy.model;

import java.util.List;

/**
 * Created by HiWin10 on 2016/9/23.
 */

public class ProxyWork {
    private String js;

    private List<Proxy> proxies;
    private int currentIndex=0;
    public static int DELAY_TIME=30000;

    public void setJs(String js){
        this.js=js;

    }
    public String getJs(){
        return js;
    }
    public void setProxies(List<Proxy> proxyList){
        proxies=proxyList;
    }
    public Proxy getNextProxy(){
        if(currentIndex>=proxies.size()){
            currentIndex=0;
        }
        return proxies.get(currentIndex++);
    }
}
