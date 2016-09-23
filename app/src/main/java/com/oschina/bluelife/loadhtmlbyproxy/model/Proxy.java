package com.oschina.bluelife.loadhtmlbyproxy.model;

/**
 * Created by HiWin10 on 2016/9/23.
 */

public class Proxy
{
    private String port;

    private String proxyIp;

    public String getPort ()
    {
        return port;
    }

    public void setPort (String port)
    {
        this.port = port;
    }

    public String getProxyIp ()
    {
        return proxyIp;
    }

    public void setProxyIp (String proxyIp)
    {
        this.proxyIp = proxyIp;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [port = "+port+", proxyIp = "+proxyIp+"]";
    }
}