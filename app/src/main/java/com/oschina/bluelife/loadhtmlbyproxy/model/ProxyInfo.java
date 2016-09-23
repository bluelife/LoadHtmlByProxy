package com.oschina.bluelife.loadhtmlbyproxy.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HiWin10 on 2016/9/23.
 */

public class ProxyInfo {
    @SerializedName("message")
    private String message;
    @SerializedName("body")
    private Body body;
    @SerializedName("status")
    private String status;
    @SerializedName("header")
    private Object header;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public Body getBody ()
    {
        return body;
    }

    public void setBody (Body body)
    {
        this.body = body;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public Object getHeader ()
    {
        return header;
    }

    public void setHeader (Object header)
    {
        this.header = header;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", body = "+body+", status = "+status+", header = "+header+"]";
    }
}
