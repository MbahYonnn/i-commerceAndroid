package com.app.i_commerce.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.app.i_commerce.MainActivity
import com.app.i_commerce.R
import com.app.i_commerce.helper.SharedPref

class LoginActivity : AppCompatActivity() {

    private lateinit var bt_login : Button
    private lateinit var bt_regist : Button
    lateinit var login: Button
    lateinit var inputEmail: EditText
    lateinit var inputPass: EditText
    lateinit var email: String
    lateinit var pass: String
    lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bt_login = findViewById(R.id.btn_login)
        bt_regist = findViewById(R.id.btn_daftar)
        inputEmail = findViewById(R.id.tv_email_login)
        inputPass = findViewById(R.id.tv_pass_login)
        s = SharedPref(this)

        bt_login.setOnClickListener {
            email = inputEmail.text.toString()
            pass = inputPass.text.toString()

            if (email.isEmpty() || pass.isEmpty()){
                if (email.isEmpty()){
                    inputEmail.error = "Email required"
                    inputEmail.requestFocus()
                    return@setOnClickListener
                } else if (pass.isEmpty()) {
                    inputPass.error = "Password required"
                    inputPass.requestFocus()
                    return@setOnClickListener
                }

            }
            else {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }
        }

        bt_regist.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }




}