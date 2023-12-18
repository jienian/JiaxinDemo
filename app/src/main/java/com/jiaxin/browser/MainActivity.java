package com.jiaxin.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private Button searchButton;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

        searchButton = (Button) findViewById(R.id.button_search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.setVisibility(View.VISIBLE);
                webView.loadUrl("https://www.baidu.com");
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (webView.getVisibility() == View.VISIBLE) {
            webView.setVisibility(View.GONE);
            searchButton.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();//退出App
        }
    }
}
