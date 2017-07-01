package com.lxx.kotlin1.activity

import android.app.ActivityOptions
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import com.lxx.kotlin1.R

class MainActivity : BaseActivity() {

    private var btnLogin: Button? = null
    private var btnTransition: Button? = null

    override fun findContextView(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent = getIntent()
        if (intent != null) {
            var intentAction = intent.getAction()
            if (Intent.ACTION_VIEW.equals(intentAction)) {
                var intentData: Uri = intent.getData()
                //var name: String = intentData.getQueryParameter("name")
                //var page: String = intentData.getQueryParameter("page")
                // Log.e("MainActivity", "initIntentData: " + name)
                // Log.e("MainActivity", "initIntentData: " + page)
            }
        }
    }

    override fun findView() {
        btnLogin = findViewById(R.id.btn_login) as Button
        btnLogin?.setOnClickListener {
            var intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }

        btnTransition = findViewById(R.id.btn_transition) as Button
        btnTransition?.setOnClickListener {

            var intent = Intent(this, Transition2Activity::class.java)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            } else {
                startActivity(intent)
            }
        }
    }

    override fun initData() {

    }
}