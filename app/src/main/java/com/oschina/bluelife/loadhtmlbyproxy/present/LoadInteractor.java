package com.oschina.bluelife.loadhtmlbyproxy.present;

import com.oschina.bluelife.loadhtmlbyproxy.model.Proxy;

/**
 * Created by HiWin10 on 2016/9/23.
 */

public interface LoadInteractor {
    void loadProxyInfo();

    void loadInjectJS();
    void loadHtmlPeriodly();
}
