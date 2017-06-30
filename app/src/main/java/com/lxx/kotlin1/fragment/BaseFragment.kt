package com.lxx.kotlin1.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by android on 2017/6/12.
 */
abstract class BaseFragment : Fragment() {

    abstract fun findContentView(): Int

    abstract fun findView()

    abstract fun setListener4View()

    abstract fun _onCreateView()

    var mActivity: Activity? = null
    var rootView: View? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mActivity = context as Activity?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater?.inflate(findContentView(), null)
        findView()
        setListener4View()
        _onCreateView()
        return rootView
    }
}
