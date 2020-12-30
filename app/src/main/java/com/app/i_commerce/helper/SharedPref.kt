package com.app.i_commerce.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Leon Truzqy Zainun on 30,December,2020
 */
class SharedPref(activity: Activity) {
    val login = "login"

    val mypref = "MAIN_PREF"
    val sp: SharedPreferences

    init{
        sp = activity.getSharedPreferences(mypref, Context.MODE_PRIVATE)
    }
    fun setStatusLogin(status: Boolean){
        sp.edit().putBoolean(login, status).apply()
    }
    fun getStatusLogin():Boolean{
        return sp.getBoolean(login, false)
    }
}