package com.inyongtisto.tokoonline.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPref(activity: Activity) {

    val login = "login"
    val nama = "nama"
    val phone = "phone"
    val email = "email"

    val mypref = "MAIN_PRF"
    val sp: SharedPreferences

    init {
        sp = activity.getSharedPreferences(mypref, Context.MODE_PRIVATE)
    }

    fun setStatusLogin(status: Boolean) {
        sp.edit().putBoolean(login, status).apply()
    }

    fun getStatusLogin(): Boolean {
        return sp.getBoolean(login, false)
    }

    fun setString(key: String, vlaue: String) {
        sp.edit().putString(key, vlaue).apply()
    }

    fun getString(key: String): String {
        return sp.getString(key, "")!!
    }

}