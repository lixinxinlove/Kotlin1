package com.lxx.kotlin1.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.lxx.kotlin1.R

/**
 * Created by android on 2017/6/30.
 */
class MyView(context: Context?) : View(context) {

    private val TAG: String = "MyView"

    private var paint: Paint? = null
    private var mWidth: Int = 0
    private var mHeight: Int = 0
    private var mLineColor: Int = 0

    init {
        initData()
    }

    constructor(context: Context?, attrs: AttributeSet?) : this(context) {
        val a = context?.obtainStyledAttributes(attrs, R.styleable.MyView)
        mLineColor = a?.getColor(R.styleable.MyView_lineColor, 0xFFFF0000.toInt())!!
        initData()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs) {
        val a = context?.obtainStyledAttributes(attrs, R.styleable.MyView)
        mLineColor = a?.getColor(R.styleable.MyView_lineColor, 0xFFFF0000.toInt())!!
        initData()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        var specWidthMode = MeasureSpec.getMode(widthMeasureSpec)

        var specHeightMode = MeasureSpec.getMode(heightMeasureSpec)


        when (specWidthMode) {

            MeasureSpec.EXACTLY -> {
                mWidth = width

            }
            MeasureSpec.UNSPECIFIED -> {
                mWidth = 500
            }
            MeasureSpec.AT_MOST -> {
                mWidth = width
            }
        }

        when (specHeightMode) {

            MeasureSpec.EXACTLY -> {
                mHeight = height

            }
            MeasureSpec.UNSPECIFIED -> {
                mHeight = 500
            }
            MeasureSpec.AT_MOST -> {
                mHeight = height
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawLine(0f, 0f, mWidth.toFloat(), mHeight.toFloat(), paint)
        canvas?.drawCircle(mWidth / 2.toFloat(), mHeight / 2.toFloat(), 15f, paint)

        var rectF = RectF(0f, 0f, mWidth.toFloat(), mHeight.toFloat())


        var startAngle: Float = 0f

        paint?.style = Paint.Style.FILL
        paint?.color = 0xFFFF0000.toInt()
        canvas?.drawArc(rectF, startAngle, 30f, true, paint)
        paint?.color = 0xFFFFFF00.toInt()
        startAngle += 30f
        canvas?.drawArc(rectF, startAngle, 90f, true, paint)
        paint?.color = 0xFF00FFFF.toInt()
        startAngle += 90f
        canvas?.drawArc(rectF, startAngle, 70f, true, paint)
        paint?.color = 0xFF0000FF.toInt()
        startAngle += 70f
        canvas?.drawArc(rectF, startAngle, 90f, true, paint)
        paint?.color = 0xFFFF00FF.toInt()
        startAngle += 90f
        canvas?.drawArc(rectF, startAngle, 80f, true, paint)


    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        //  mWidth = width
        //mHeight = height

    }

    private fun initData() {
        paint = Paint()
        paint?.color = mLineColor
        paint?.strokeWidth = 5f
        paint?.isAntiAlias = true
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when (event?.action) {
            MotionEvent.ACTION_MOVE -> {
                Log.e(TAG, "MOVE")
            }
            MotionEvent.ACTION_UP -> {
                Toast.makeText(context, "UP ", Toast.LENGTH_SHORT).show()
            }
            MotionEvent.ACTION_DOWN -> {
                Toast.makeText(context, "DOWN", Toast.LENGTH_SHORT).show()
            }
        }

        return true
    }
}