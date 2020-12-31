package com.app.i_commerce.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import com.app.i_commerce.R
import com.app.i_commerce.helper.Helper
import com.app.i_commerce.model.Produk
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class DetailProdukActivity : AppCompatActivity() {
    lateinit var produk: Produk
    lateinit var tv_harga: TextView
    lateinit var tv_nama: TextView
    lateinit var tv_deskripsi: TextView
    lateinit var toolbarz: Toolbar
    lateinit var iv_image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_produk)
        tv_nama = findViewById(R.id.tv_nama_detail)
        tv_harga = findViewById(R.id.tv_harga_detail)
        tv_deskripsi = findViewById(R.id.tv_deskripsi_detail)
        iv_image = findViewById(R.id.image_detail)

        getInfo()
    }

    fun getInfo() {
        val data = intent.getStringExtra("extra")
        produk = Gson().fromJson<Produk>(data, Produk::class.java)

        // set Value
        tv_nama.text = produk.name
        tv_harga.text = Helper().gantiRupiah(produk.harga)
        tv_deskripsi.text = produk.deskripsi

        val img = "http://192.168.1.27/blog/public/storage/produk/" + produk.image
        Picasso.get()
            .load(img)
            .placeholder(R.drawable.product)
            .error(R.drawable.product)
            .resize(400, 400)
            .into(iv_image)

        // setToolbar
        setSupportActionBar(findViewById(R.id.toolbar_detail))
        supportActionBar!!.title = produk.name
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}