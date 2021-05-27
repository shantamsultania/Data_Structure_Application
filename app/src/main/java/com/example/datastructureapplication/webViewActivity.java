package com.example.datastructureapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class webViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url").trim();
        Log.d("test url", "onCreate: " + url);

        WebView webView = findViewById(R.id.webview);

        webView.getSettings().setSupportZoom(false);

        if (url.isEmpty() || url == null) {
            webView.loadUrl("www.geeksforgeeks.com/");
        } else {
            webView.loadUrl(url);
        }

    }
}
