package com.app.i_commerce.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.app.i_commerce.MainActivity
import com.app.i_commerce.R

class LoginActivity : AppCompatActivity() {

    private lateinit var bt_login : Button
    lateinit var login: Button
    lateinit var inputEmail: EditText
    lateinit var inputPass: EditText
    lateinit var email: String
    lateinit var pass: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bt_login = findViewById(R.id.btn_login)
        inputEmail = findViewById(R.id.tv_email_login)
        inputPass = findViewById(R.id.tv_pass_login)

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

    }
}