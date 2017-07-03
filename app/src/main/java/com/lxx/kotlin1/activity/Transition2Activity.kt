package com.lxx.kotlin1.activity

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Outline
import android.graphics.Path
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.graphics.Palette
import android.transition.Explode
import android.transition.Slide
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import com.lxx.kotlin1.R


class Transition2Activity : AppCompatActivity() {

    private var iv: ImageView? = null
    private var ivPath: ImageView? = null
    private var image: ImageView? = null
    private var tv1: TextView? = null
    private var tvTop: TextView? = null

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

        image?.setOnClickListener { anim() }

        iv = findViewById(R.id.iv) as ImageView
        iv?.setOnClickListener {
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
        //image?.setOutlineProvider(viewOutlineProvider)
        tv1?.setOutlineProvider(viewOutlineProvider)
        // image?.clipToOutline = true
        tv1?.clipToOutline = true


        tvTop = findViewById(R.id.tv_top) as TextView
        //  fun1()
        changeTopBgColor()
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
    }


    fun anim() {
        var cx: Int? = image?.width
        var cy: Int? = image?.height

        // get the final radius for the clipping circle
        var finalRadius: Float? = cx?.toFloat()

        // create the animator for this view (the start radius is zero)
        var anim = ViewAnimationUtils.createCircularReveal(image, cx!!, cy!!, 0f, finalRadius!!)

        // make the view visible and start the animation
        image?.setVisibility(View.VISIBLE)
        anim.start()
    }

    fun fun1() {
        Palette.from(BitmapFactory.decodeResource(resources, R.mipmap.ic))
                .generate { p ->
                    var s0: Palette.Swatch? = p.vibrantSwatch       //获取到充满活力的这种色调
                    var s1: Palette.Swatch? = p.darkVibrantSwatch    //获取充满活力的黑
                    var s2: Palette.Swatch? = p.lightVibrantSwatch   //获取充满活力的亮
                    var s3: Palette.Swatch? = p.mutedSwatch           //获取柔和的色调
                    var s4: Palette.Swatch? = p.darkMutedSwatch      //获取柔和的黑
                    var s6: Palette.Swatch? = p.lightMutedSwatch    //获取柔和的亮

                    ///  tvTop?.setBackgroundColor(s2!!.bodyTextColor)
                    //  tvTop?.setTextColor(s2!!.titleTextColor)
                }
    }

    fun changeTopBgColor() {
        // 用来提取颜色的Bitmap
        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.palett)
        // Palette的部分
        val builder = Palette.from(bitmap)
        builder.generate { palette ->
            //获取到充满活力的这种色调
            var vibrant = palette.vibrantSwatch
            var vibrant1 = palette.lightMutedSwatch
            //   tvTop?.setBackgroundColor(vibrant!!.bodyTextColor)
            //   tvTop?.setTextColor(vibrant1!!.titleTextColor)
        }
    }


    // Return a palette's vibrant swatch after checking that it exists
    private fun checkVibrantSwatch(p: Palette): Palette.Swatch {
        val vibrant = p.vibrantSwatch
        return vibrant!!
    }


    // Generate palette synchronously and return it
    fun createPaletteSync(bitmap: Bitmap): Palette {
        val p = Palette.from(bitmap).generate()
        return p
    }

    // Generate palette asynchronously and use it on a different
    // thread using onGenerated()
    fun createPaletteAsync(bitmap: Bitmap) {

        Palette.from(bitmap).generate {
            // Use generated instance
        }
    }


    external fun stringFromJNI(): String
}
