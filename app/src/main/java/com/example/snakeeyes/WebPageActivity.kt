package com.example.snakeeyes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button


class WebPageActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_page)
        var webView=findViewById<WebView>(R.id.webView)



        webView.webViewClient = WebViewClient();
        webView.loadUrl("https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwiwmP_lt4H3AhU0q1YBHcNODuUQFnoECBEQAQ&url=http%3A%2F%2Fwww.health.gov.lk%2Fmoh_final%2Fenglish%2F&usg=AOvVaw1JIolPM5JbALBFB3kCx-ej")

        // this will enable the javascript settings
        webView.settings.javaScriptEnabled = true

        // if you want to enable zoom feature
        webView.settings.setSupportZoom(true)
    }

  /**  override fun onBackPressed() {
        // if your webview can go back it will go back
        if (webView.canGoBack())
            webView.goBack()
        // if your webview cannot go back
        // it will exit the application
        else
            super.onBackPressed()
    } **/
}