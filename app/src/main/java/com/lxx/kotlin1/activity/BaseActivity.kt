package com.lxx.kotlin1.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by android on 2017/6/22.
 * 基类
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun findContextView(): Int
    abstract fun findView()
    abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(findContextView())
        findView()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}