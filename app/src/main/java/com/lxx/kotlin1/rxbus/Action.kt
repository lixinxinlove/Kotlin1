package com.lxx.kotlin1.rxbus


/**
 * rxbus 对象
 */
data class Action(var code: Int, var data: Any) {
    override fun toString(): String {
        return code.toString() + data.toString()
    }
}
