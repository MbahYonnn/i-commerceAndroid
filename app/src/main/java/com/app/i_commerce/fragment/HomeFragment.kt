package com.app.i_commerce.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.app.i_commerce.R
import com.app.i_commerce.adapter.AdapterProduk
import com.app.i_commerce.adapter.AdapterSlider
import com.app.i_commerce.app.ApiConfig
import com.app.i_commerce.model.Produk
import com.app.i_commerce.model.ResponModel
import com.app.i_commerce.viewmodel.HomeViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    lateinit var vpslider: ViewPager
    lateinit var rvproduk: RecyclerView
    lateinit var rvprodukLaris: RecyclerView
    lateinit var rvprodukElektronik: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.home_fragment, container, false)
        initView(view)
        getProduk()



        return view
    }

    fun displayProduk(){
        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.asset1)
        arrSlider.add(R.drawable.asset2)
        arrSlider.add(R.drawable.asset3)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpslider.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager2 = LinearLayoutManager(activity)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager3 = LinearLayoutManager(activity)
        layoutManager3.orientation = LinearLayoutManager.HORIZONTAL

        rvproduk.adapter = AdapterProduk(requireActivity(),listProduk)
        rvproduk.layoutManager = layoutManager

        rvprodukLaris.adapter = AdapterProduk(requireActivity(),listProduk)
        rvprodukLaris.layoutManager = layoutManager2

        rvprodukElektronik.adapter = AdapterProduk(requireActivity(),listProduk)
        rvprodukElektronik.layoutManager = layoutManager3

    }
    private var listProduk: ArrayList<Produk> = ArrayList()
    fun getProduk(){
        ApiConfig.instanceRetrofit.getProduk().enqueue(object : Callback<ResponModel>{
            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                //
            }
            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val res = response.body()!!
                if (res.success == 1){
                    listProduk = res.produks
                    displayProduk()
                }
            }
        })

    }

    fun initView(view: View){
        vpslider = view.findViewById(R.id.vp_slider)
        rvproduk = view.findViewById(R.id.rv_produk)
        rvprodukLaris = view.findViewById(R.id.rv_produkTerlaris)
        rvprodukElektronik = view.findViewById(R.id.rv_Elektronik)
    }
//    val arrProduk: ArrayList<Produk>get() {
//        val arr = ArrayList<Produk>()
//        val p1 = Produk()
//        p1.nama = "Samsung Galaxy A7"
//        p1.harga = "Rp.4.275.000"
//        p1.gambar = R.drawable.samsung_a7
//
//        val p2 = Produk()
//        p2.nama = "Google Pixel 4"
//        p2.harga = "Rp.12.375.000"
//        p2.gambar = R.drawable.pixel_4
//
//        val p3 = Produk()
//        p3.nama = "Xiaomi mi10"
//        p3.harga = "Rp.9.875.000"
//        p3.gambar = R.drawable.xiaomi_mi10
//
//        arr.add(p1)
//        arr.add(p2)
//        arr.add(p3)
//
//        return arr
//    }
//
//    val arrProdukLaris: ArrayList<Produk>get() {
//        val arr = ArrayList<Produk>()
//        val p1 = Produk()
//        p1.nama = "Lenovo Legion 5"
//        p1.harga = "Rp.17.300.000"
//        p1.gambar = R.drawable.legion_5
//
//        val p2 = Produk()
//        p2.nama = "Asus TUF A15"
//        p2.harga = "Rp.13.699.000"
//        p2.gambar = R.drawable.tuf_a15
//
//        val p3 = Produk()
//        p3.nama = "HP Omen 15"
//        p3.harga = "Rp.22.575.000"
//        p3.gambar = R.drawable.omen_15
//
//        val p4 = Produk()
//        p4.nama = "Xiaomi mi10"
//        p4.harga = "Rp.9.875.000"
//        p4.gambar = R.drawable.xiaomi_mi10
//
//        arr.add(p1)
//        arr.add(p2)
//        arr.add(p3)
//        arr.add(p4)
//
//        return arr
//    }
//
//    val arrProdukElektronik: ArrayList<Produk>get() {
//        val arr = ArrayList<Produk>()
//        val p1 = Produk()
//        p1.nama = "Samsung Galaxy A7"
//        p1.harga = "Rp.4.275.000"
//        p1.gambar = R.drawable.samsung_a7
//
//        val p2 = Produk()
//        p2.nama = "Google Pixel 4"
//        p2.harga = "Rp.12.375.000"
//        p2.gambar = R.drawable.pixel_4
//
//        val p3 = Produk()
//        p3.nama = "Xiaomi mi10"
//        p3.harga = "Rp.9.875.000"
//        p3.gambar = R.drawable.xiaomi_mi10
//
//        val p4 = Produk()
//        p4.nama = "Lenovo Legion 5"
//        p4.harga = "Rp.17.300.000"
//        p4.gambar = R.drawable.legion_5
//
//        val p5 = Produk()
//        p5.nama = "Asus TUF A15"
//        p5.harga = "Rp.13.699.000"
//        p5.gambar = R.drawable.tuf_a15
//
//        val p6 = Produk()
//        p6.nama = "HP Omen 15"
//        p6.harga = "Rp.22.575.000"
//        p6.gambar = R.drawable.omen_15
//
//        val p7 = Produk()
//        p7.nama = "Xiaomi mi10"
//        p7.harga = "Rp.9.875.000"
//        p7.gambar = R.drawable.nitro_5
//
//        arr.add(p1)
//        arr.add(p2)
//        arr.add(p3)
//        arr.add(p4)
//        arr.add(p5)
//        arr.add(p6)
//        arr.add(p7)
//
//        return arr
//    }


}