package com.oschina.bluelife.loadhtmlbyproxy.view;

import com.oschina.bluelife.loadhtmlbyproxy.model.Proxy;

/**
 * Created by HiWin10 on 2016/9/23.
 */

public interface HtmlView {
    void showProgress();
    void hideProgress();
    void showError();
    void showHtml(String url,Proxy proxy,String js);
    void showProxyContent(Proxy proxy);
}