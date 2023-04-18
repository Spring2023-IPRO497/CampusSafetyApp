package com.campussafetyapp.iitridesafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity2 extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String url = "https://iit.okta.com/login/login.htm?fromURI=%2Fapp%2Fiit_oktacirrusbridgecasuid_1%2Fexk1w3taz8o1onhvK697%2Fsso%2Fsaml%3FSAMLRequest%3DjVJNj9sgFPwrFncbm9jZNUoipc2hUbdqtEl72EtEzEuC1gbKg23aX1%252FsfHSrlVY9IYY3M8zoTVB0reXz4I%252F6EX4EQJ%252BculYjHx6mJDjNjUCFXIsOkPuGr%252BdfHjjLcm6d8aYxLXlFeZ8hEMF5ZTRJlosp2UpWjtj9jkExLuS%252BLPd1vYdKVHJcyd2%252BrEdjYKys6rwgyXdwGJlTEoUiHTHAUqMX2kcoZ6M0L9PibsMYZzmvyieSLGIapYUfWEfvLXJKlfKZefYia0xHhbU9sO2BRjkXcOeUPEAjMCi5LSicnoufIy9%252B35vC6OPL53F9RxEN7bOSZH7N89FoDB24NbgX1cC3x4e%252Fjq05KJ31viAD7YwMLWT2aAcNiueTpaLBAY2D6UBJz3%252FZxppPv0iyurT9QWmp9OH9onfnIeSfNptVuvq63pDZpPfhQ3FudqtD2tvXYuqL54S%252Bnp2cl2TdGBs1r9fLuoBbLv5L7V%252FGFbuJ0rebOPsD%26RelayState%3Dhttps%253A%252F%252Flogin.iit.edu%252Fcas%252Flogin%253FrequestLogged%253Dtrue%2526service%253Dhttps%25253A%25252F%25252Fmy.iit.edu%25252Fc%25252Fportal%25252Flogin";

        webView = findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String checkUrl) {
                super.onPageFinished(view, checkUrl);
                if(checkUrl.equals("https://my.iit.edu/web/home-community/welcome")) {
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);
                }
            }
        });
        webView.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}