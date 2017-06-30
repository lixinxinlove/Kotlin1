package com.lxx.kotlin1.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import com.lxx.kotlin1.R

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment() {

    var i: Int = 0
    var tv: TextView? = null


    var webView: WebView? = null

    override fun findContentView(): Int {
        return R.layout.fragment_home
    }

    override fun findView() {
        tv = rootView?.findViewById(R.id.tv) as TextView

        webView = rootView?.findViewById(R.id.wv) as WebView
        webView?.setWebChromeClient(WebChromeClient())
        webView?.setWebViewClient(WebViewClient())
        webView?.loadUrl("file:///android_asset/my.html")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        i = arguments.getInt("key", 0)
        Log.e("Fragment", i.toString() + "onCreate")
    }

    override fun setListener4View() {
    }

    override fun _onCreateView() {
        tv?.setText("lee $i")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Fragment", i.toString() + "onDestroy")
    }
}
