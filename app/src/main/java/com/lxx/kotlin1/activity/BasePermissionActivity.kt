package com.lxx.kotlin1.activity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity


/**
 * Created by android on 2017/6/22.
 */
abstract class BasePermissionActivity : AppCompatActivity() {


    private val REQUEST_PERMISSION_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            onCheckPermission()
        }
    }

    protected fun onCheckPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            requestWriteExternalPermissions()
        } else {
            onPermissionsResultGranted()
        }
    }

    private var alertDialog: AlertDialog? = null
    private fun requestWriteExternalPermissions() {
        val grantedMessage = "没有权限"
        if (alertDialog != null && alertDialog!!.isShowing()) {
            alertDialog?.show()
        } else {
            alertDialog = AlertDialog.Builder(this)
                    .setCancelable(false)
                    .setMessage(grantedMessage)
                    .setPositiveButton("确定",
                            { dialog, which -> onCheckPermission() })
                    .create()
            alertDialog?.show()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    onPermissionsResultGranted()
                } else {
                    onPermissionsResultDenied()
                }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
    }


    abstract fun onPermissionsResultGranted()

    abstract fun onPermissionsResultDenied()


}