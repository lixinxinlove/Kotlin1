package com.lxx.kotlin1.activity

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Explode
import android.transition.Slide
import android.view.Gravity
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.lxx.kotlin1.R

class Transition2Activity : AppCompatActivity() {
    private var iv: ImageView? = null

    init {
        System.loadLibrary("native-lib")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
            var slide = Slide()
            slide.setDuration(300)
            slide.setSlideEdge(Gravity.LEFT)
            window.enterTransition = Explode().setDuration(300)
            window.exitTransition = Explode().setDuration(300)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition2)
        iv = findViewById(R.id.iv) as ImageView
        iv?.setOnClickListener { finish() }

        var tv: TextView? = null
        tv = findViewById(R.id.tv) as TextView
        tv.text = stringFromJNI()
    }



    external fun stringFromJNI(): String
}
