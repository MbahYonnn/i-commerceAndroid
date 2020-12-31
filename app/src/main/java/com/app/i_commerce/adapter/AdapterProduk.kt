package com.app.i_commerce.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.app.i_commerce.R
import com.app.i_commerce.activity.DetailProdukActivity
import com.app.i_commerce.model.Produk
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Leon Truzqy Zainun on 29,December,2020
 */
class AdapterProduk(var activity: Activity, var data: ArrayList<Produk>):RecyclerView.Adapter<AdapterProduk.Holder>() {
    class Holder(view: View):RecyclerView.ViewHolder(view){
        val tvNama = view.findViewById<TextView>(R.id.tv_namaProduk)
        val tvHarga = view.findViewById<TextView>(R.id.tv_hargaProduk)
        val imgProduk = view.findViewById<ImageView>(R.id.img_produk)
        val layout = view.findViewById<CardView>(R.id.layout_utama)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return Holder(view)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvNama.text = data[position].name
        holder.tvHarga.text = NumberFormat.getCurrencyInstance(Locale("in","ID")).format(Integer.valueOf(data[position].harga))
       // holder.imgProduk.setImageResource(data[position].image)
        val image = "http://192.168.1.27/blog/public/storage/produk/" + data[position].image
        Picasso.get()
            .load(image)
            .placeholder(R.drawable.product)
            .error(R.drawable.product)
            .into(holder.imgProduk)

        holder.layout.setOnClickListener {
            val activiti = Intent(activity, DetailProdukActivity::class.java)
            val str = Gson().toJson(data[position], Produk::class.java)
            activiti.putExtra("extra", str)
            activity.startActivity(activiti)
        }
    }


}