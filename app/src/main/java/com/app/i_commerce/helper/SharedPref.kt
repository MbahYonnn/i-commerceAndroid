package com.app.i_commerce.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.app.i_commerce.model.User
import com.google.gson.Gson

/**
 * Created by Leon Truzqy Zainun on 30,December,2020
 */
class SharedPref(activity: Activity) {
    val login = "login"
    val nama = "nama"
    val phone = "phone"
    val email = "email"

    val user = "user"

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
    fun setUser(value: User) {
        val data: String = Gson().toJson(value, User::class.java)
        sp.edit().putString(user, data).apply()
    }

    fun getUser(): User? {
        val data:String = sp.getString(user, null) ?: return null
        return Gson().fromJson<User>(data, User::class.java)
    }

    fun setString(key: String, vlaue: String) {
        sp.edit().putString(key, vlaue).apply()
    }

    fun getString(key: String): String {
        return sp.getString(key, "")!!
    }

    fun clear(){
        sp.edit().clear().apply()
    }
}