package com.lxx.kotlin1.utils

/**
 * Created by android on 2017/6/10.
 */

object DateTimeUtil {
    fun add(x: Int, y: Int): Int {
        return x + y
    }

    fun getLength(x: Any): Int {
        if (x is String) {
            return x.length
        } else {
            return 0
        }
    }
}