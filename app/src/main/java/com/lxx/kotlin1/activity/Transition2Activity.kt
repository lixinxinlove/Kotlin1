package com.lxx.kotlin1.activity

import android.animation.ObjectAnimator
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Outline
import android.graphics.Path
import android.os.Build
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.transition.Explode
import android.transition.Slide
import android.view.Gravity
import android.view.View
import android.view.ViewOutlineProvider
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.lxx.kotlin1.R
import com.lxx.kotlin1.receiver.LocalBroadcastReceiver


class Transition2Activity : AppCompatActivity() {

    val localReceiver: LocalBroadcastReceiver? = LocalBroadcastReceiver()


    private var iv: ImageView? = null
    private var ivPath: ImageView? = null

    private var image: ImageView? = null

    private var tv1: TextView? = null

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

        ivPath = findViewById(R.id.iv_path) as ImageView

        ivPath?.setOnClickListener {
            pathAnim()
        }

        image = findViewById(R.id.image) as ImageView
        tv1 = findViewById(R.id.tv1) as TextView

        val localBroadcastManager = LocalBroadcastManager.getInstance(this)
        val intentFilter = IntentFilter()
        intentFilter.addAction("lee")
        //    localBroadcastManager.registerReceiver(localReceiver, intentFilter)


        iv = findViewById(R.id.iv) as ImageView
        iv?.setOnClickListener {

            //LocalBroadcastManager.getInstance(this).sendBroadcast(Intent("com.lxx.kotlin1.lee"))
            sendBroadcast(Intent("com.lxx.kotlin1.lee"))

        }

        var tv: TextView? = null
        tv = findViewById(R.id.tv) as TextView
        tv.text = stringFromJNI()


        val viewOutlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                // 可以指定圆形，矩形，圆角矩形，path
                outline.setOval(0, 0, view.width, view.height)
            }
        }

        image?.setOutlineProvider(viewOutlineProvider)
        tv1?.setOutlineProvider(viewOutlineProvider)
        image?.clipToOutline = true
        tv1?.clipToOutline = true


    }


    fun pathAnim() {

        val path: Path? = Path()
        path?.rQuadTo(0f, 500f, 300f, 0f)
        path?.rQuadTo(0f, 0f, 300f, 0f)
        path?.cubicTo(0f, 0f, 50f, 150f, 800f, 800f)
        var mAnimator: ObjectAnimator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mAnimator = ObjectAnimator.ofFloat(ivPath, View.X, View.Y, path)
            mAnimator.setDuration(5000)
            mAnimator.start()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        //   unregisterReceiver(localReceiver)
    }

    external fun stringFromJNI(): String
}
