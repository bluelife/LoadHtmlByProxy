package com.oschina.bluelife.loadhtmlbyproxy.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by HiWin10 on 2016/9/23.
 */

public class Data
{
    @SerializedName("timestamp")
    private String timestamp;
    @SerializedName("taskId")
    private String taskId;
    @SerializedName("jsurl")
    private String jsurl;
    @SerializedName("proxy")
    private List<Proxy> proxyList;
    @SerializedName("targetUrl")
    private String targetUrl;

    public String getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getTaskId ()
    {
        return taskId;
    }

    public void setTaskId (String taskId)
    {
        this.taskId = taskId;
    }

    public String getJsurl ()
    {
        return jsurl;
    }

    public void setJsurl (String jsurl)
    {
        this.jsurl = jsurl;
    }

    public List<Proxy> getProxyList ()
    {
        return proxyList;
    }

    public void setProxyList (List<Proxy> proxy)
    {
        this.proxyList = proxy;
    }

    public String getTargetUrl ()
    {
        return targetUrl;
    }

    public void setTargetUrl (String targetUrl)
    {
        this.targetUrl = targetUrl;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [timestamp = "+timestamp+", taskId = "+taskId+", jsurl = "+jsurl+", proxy = "+proxyList+", targetUrl = "+targetUrl+"]";
    }
}
