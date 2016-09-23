package com.oschina.bluelife.loadhtmlbyproxy.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HiWin10 on 2016/9/23.
 */

public class Body
{
    @SerializedName("data")
    private Data data;

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+"]";
    }
}
