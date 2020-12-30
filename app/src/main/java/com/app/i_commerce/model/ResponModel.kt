package com.app.i_commerce.model

/**
 * Created by Leon Truzqy Zainun on 30,December,2020
 */
class ResponModel {
    var success = 0
    lateinit var message: String
    var user = User()
    var produks: ArrayList<Produk> = ArrayList()
}