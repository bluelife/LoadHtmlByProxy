package com.oschina.bluelife.loadhtmlbyproxy.present;

import android.os.Handler;
import android.util.Log;

import com.oschina.bluelife.loadhtmlbyproxy.model.Proxy;
import com.oschina.bluelife.loadhtmlbyproxy.model.ProxyInfo;
import com.oschina.bluelife.loadhtmlbyproxy.model.ProxyWork;
import com.oschina.bluelife.loadhtmlbyproxy.service.ProxyTaskService;
import com.oschina.bluelife.loadhtmlbyproxy.view.HtmlView;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HiWin10 on 2016/9/23.
 */

public class LoadPresent implements LoadInteractor {
    private HtmlView htmlView;
    private ProxyTaskService taskService;
    private ProxyInfo proxyInfo;
    private ProxyWork proxyWork;
    private String url;
    private Handler handler;

    public LoadPresent(HtmlView view,ProxyTaskService service,Handler handler){
        htmlView=view;
        taskService=service;
        this.handler=handler;
    }

    @Override
    public void loadProxyInfo() {
        htmlView.showProgress();
        Call<ProxyInfo> proxyInfoCall=taskService.getProxyApi().loadProxyInfo();
        proxyInfoCall.enqueue(new Callback<ProxyInfo>() {
            @Override
            public void onResponse(Call<ProxyInfo> call, Response<ProxyInfo> response) {

                proxyInfo=response.body();
                url=proxyInfo.getBody().getData().getTargetUrl();
                loadInjectJS();
            }

            @Override
            public void onFailure(Call<ProxyInfo> call, Throwable t) {
                htmlView.showError();
            }
        });

    }

    @Override
    public void loadInjectJS() {
        Call<ResponseBody> call=taskService.getJsApi().loadInjectJS(proxyInfo.getBody().getData().getJsurl());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                htmlView.hideProgress();
                try {
                    String result=response.body().string();
                    proxyWork=new ProxyWork();
                    proxyWork.setJs(result);
                    proxyWork.setProxies(proxyInfo.getBody().getData().getProxyList());
                    loadHtmlPeriodly();
                } catch (IOException e) {
                    e.printStackTrace();
                    htmlView.showError();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                htmlView.showError();
            }
        });
    }

    private void loadHtml(){
        htmlView.showHtml(url,proxyWork.getNextProxy(),proxyWork.getJs());
    }
    @Override
    public void loadHtmlPeriodly() {
        loadHtml();
        LoadHtmlTask loadHtmlTask=new LoadHtmlTask();
        handler.postDelayed(loadHtmlTask,ProxyWork.DELAY_TIME);
    }
    public void stopLoad(){
        //TODO
        //handler.removeCallbacks();
    }

    public class LoadHtmlTask implements Runnable {

        @Override
        public void run() {
            loadHtmlPeriodly();
        }
    }
}
