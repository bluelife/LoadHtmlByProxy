package com.oschina.bluelife.loadhtmlbyproxy;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.oschina.bluelife.loadhtmlbyproxy.model.Proxy;
import com.oschina.bluelife.loadhtmlbyproxy.present.LoadPresent;
import com.oschina.bluelife.loadhtmlbyproxy.service.ProxyTaskService;
import com.oschina.bluelife.loadhtmlbyproxy.view.HtmlView;


public class MainActivity extends AppCompatActivity implements HtmlView{

    private LoadPresent loadPresent;
    private WebView webView;
    private ProgressBar progressBar;
    private TextView proxyText;
    private Handler handler=new Handler();
    private String js;
    private String APP_NAME="com.oschina.bluelife.loadhtmlbyproxy.App";
    private String TAG="MainAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        ProxyTaskService taskService=((App)getApplication()).getProxyTaskService();

        webView=(WebView)findViewById(R.id.webView);
        proxyText=(TextView)findViewById(R.id.proxyInfo);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        proxyText.setText("");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                String injectJs="javascript:"+js;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    webView.evaluateJavascript(injectJs, null);
                    Log.w(TAG,"inject"+injectJs);
                } else {
                    webView.loadUrl(injectJs);
                }
            }
        });
        loadPresent=new LoadPresent(this,taskService,handler);
        loadPresent.loadProxyInfo();
    }

    @Override
    public void showProgress() {

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void showHtml(String url,Proxy proxy,String inject) {
        Log.w(TAG,"load "+url+","+proxy.getProxyIp()+","+proxy.getPort());
        Utils.setProxy(webView,proxy.getProxyIp(),Integer.valueOf(proxy.getPort()),APP_NAME);
        String format=String.format(getString(R.string.proxy_format),proxy.getProxyIp(),proxy.getPort());
        proxyText.setText(format);
        webView.loadUrl(url);
        js=inject;
    }

    @Override
    public void showProxyContent(Proxy proxy) {

    }
}
