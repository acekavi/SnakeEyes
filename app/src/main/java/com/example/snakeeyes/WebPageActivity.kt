package com.example.snakeeyes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.snakeeyes.R
import android.webkit.WebView
import kotlin.jvm.internal.Intrinsics
import android.webkit.WebViewClient
import android.webkit.WebSettings

class WebPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_web_page)
        val webView = findViewById<View>(R.id.webView) as WebView
        Intrinsics.checkNotNullExpressionValue(webView, "webView")
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwiwmP_lt4H3AhU0q1YBHcNODuUQFnoECBEQAQ&url=http%3A%2F%2Fwww.health.gov.lk%2Fmoh_final%2Fenglish%2F&usg=AOvVaw1JIolPM5JbALBFB3kCx-ej")
        val var10000 = webView.settings
        Intrinsics.checkNotNullExpressionValue(var10000, "webView.settings")
        var10000.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
    }
}