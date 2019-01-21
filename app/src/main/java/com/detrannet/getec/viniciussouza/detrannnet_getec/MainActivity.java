package com.detrannet.getec.viniciussouza.detrannnet_getec;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview = (WebView) findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(false);
        webview.loadUrl("https://detrannet.detran.ro.gov.br/");
        //WebSettings webSettings = webview.getSettings();
        //webSettings.setJavaScriptEnabled(true);
        //webview.loadUrl("https://horsy.com.br");

    }

    public class myWebviewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);

            return true;
        }
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()){
            webview.goBack();
            return true;
        }

        return super.onKeyLongPress(keyCode, event);
    }
}