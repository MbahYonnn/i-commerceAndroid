package com.app.i_commerce.model

import java.io.Serializable

/**
 * Created by Leon Truzqy Zainun on 29,December,2020
 */
class Produk : Serializable {
    lateinit var nama: String
    lateinit var harga: String
    var gambar: Int = 0
}