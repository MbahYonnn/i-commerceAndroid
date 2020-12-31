package com.app.i_commerce.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.app.i_commerce.MainActivity
import com.app.i_commerce.R
import com.app.i_commerce.app.ApiConfig
import com.app.i_commerce.helper.SharedPref
import com.app.i_commerce.model.ResponModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var bt_login: Button
    private lateinit var bt_regist: Button
    lateinit var login: Button
    lateinit var inputEmail: EditText
    lateinit var inputPass: EditText
    lateinit var email: String
    lateinit var pass: String
    lateinit var s: SharedPref
    lateinit var coordinatorLayout: CoordinatorLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        coordinatorLayout = findViewById(R.id.login_coordinator_layout)
        bt_login = findViewById(R.id.btn_login)
        bt_regist = findViewById(R.id.btn_daftar)
        inputEmail = findViewById(R.id.tv_email_login)
        inputPass = findViewById(R.id.tv_pass_login)
        s = SharedPref(this)

        bt_login.setOnClickListener {
            email = inputEmail.text.toString()
            pass = inputPass.text.toString()

            if (email.isEmpty() || pass.isEmpty()) {
                if (email.isEmpty()) {
                    inputEmail.error = "Email tidak boleh kosong"
                    inputEmail.requestFocus()
                    return@setOnClickListener
                } else if (pass.isEmpty()) {
                    inputPass.error = "Password tidak boleh kosong"
                    inputPass.requestFocus()
                    return@setOnClickListener
                }

            }
            ApiConfig.instanceRetrofit.login(inputEmail.text.toString(), inputPass.text.toString())
                .enqueue(
                    object : Callback<ResponModel> {
                        @SuppressLint("ShowToast")
                        override fun onResponse(
                            call: Call<ResponModel>,
                            response: Response<ResponModel>
                        ) {
                            val respon = response.body()!!
                            if (respon.success == 1) {
                                s.setStatusLogin(true)
                                s.setString(s.nama, respon.user.name)
                                s.setString(s.email, respon.user.email)
                                finish()
                                val i = Intent(this@LoginActivity, MainActivity::class.java)
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                                startActivity(i)
                                finish()
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Selamat datang " + respon.user.name,
                                    Toast.LENGTH_SHORT
                                ).show()
//                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                            } else {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Error: " + respon.user.name,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        @SuppressLint("ShowToast")
                        override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                            com.app.i_commerce.widget.Snackbar(coordinatorLayout, "Error check form").show()

                        }

                    })
//
        }

        bt_regist.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }


}