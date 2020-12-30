package com.app.i_commerce.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.app.i_commerce.R
import com.app.i_commerce.app.ApiConfig
import com.app.i_commerce.model.ResponModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    lateinit var txt_nama: EditText
    lateinit var txt_pass: EditText
    lateinit var txt_email: EditText
    private lateinit var bt_register: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        bt_register = findViewById(R.id.btn_daftar_send)
        txt_nama = findViewById(R.id.tv_nama_regist)
        txt_email = findViewById(R.id.tv_email_regist)
        txt_pass = findViewById(R.id.tv_password_regist)

        bt_register.setOnClickListener {
            register()
        }
    }

    fun register() {
        if (txt_nama.text.isEmpty()) {
            txt_nama.error = "Kolom nama tidak boleh kosong"
            txt_nama.requestFocus()
            return
        } else if (txt_email.text.isEmpty()) {
            txt_email.error = "Kolom email tidak boleh kosong"
            txt_email.requestFocus()
            return
        } else if (txt_pass.text.isEmpty()) {
            txt_pass.error = "Kolom password tidak boleh kosong"
            txt_pass.requestFocus()
            return
        }
        ApiConfig.instanceRetrofit.register(txt_nama.text.toString(), txt_email.text.toString(), txt_pass.text.toString()).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.d("response", "onResponse: ")
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("response", "onResponse: ")
            }


        })
    }
}