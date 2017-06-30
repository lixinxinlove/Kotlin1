package com.lxx.kotlin1.data

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

/**
 * Created by android on 2017/6/10.
 */
@SuppressLint("ParcelCreator")
data class User(var name: String) : Parcelable {
    var age: Int = 0
    var sex: Int = 0

    constructor(name: String, age: Int) : this(name) {
        this.age = age
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(this.sex)
        dest?.writeString(this.name)
        dest?.writeInt(this.age)
    }

    override fun describeContents(): Int {
        return 0
    }


}