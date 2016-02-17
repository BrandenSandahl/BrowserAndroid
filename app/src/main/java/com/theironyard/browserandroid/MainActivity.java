package com.theironyard.browserandroid;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText addressBar;
    Button backButton, forwardButton, goButton;
    WebView webview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addressBar = (EditText) findViewById(R.id.addressText);
        backButton = (Button) findViewById(R.id.backButton);
        forwardButton = (Button) findViewById(R.id.forwardButton);
        goButton = (Button) findViewById(R.id.goButton);
        webview = (WebView) findViewById(R.id.webView);

        backButton.setOnClickListener(this);
        forwardButton.setOnClickListener(this);
        goButton.setOnClickListener(this);

        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                addressBar.setText(url);
            }
        });
    }



    @Override
    public void onClick(View v) {
        if (v == backButton) {
            webview.goBack();
        } else if (v == forwardButton) {
            webview.goForward();
        } else if (v == goButton) {
            String url = addressBar.getText().toString();
            if (!url.startsWith("http")) {
                url = "http://" + url;
            }
            webview.loadUrl(url);
        }
    }
}
