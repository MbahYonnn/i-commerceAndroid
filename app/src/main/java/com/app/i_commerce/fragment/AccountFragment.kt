package com.app.i_commerce.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.app.i_commerce.R
import com.app.i_commerce.activity.LoginActivity
import com.app.i_commerce.helper.SharedPref
import com.app.i_commerce.viewmodel.AccountViewModel

class AccountFragment : Fragment() {

    companion object {
        fun newInstance() = AccountFragment()
    }

    private lateinit var viewModel: AccountViewModel
    lateinit var s:SharedPref
    lateinit var btn_Logout: Button
    lateinit var tv_nama: TextView
    lateinit var tv_email: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.account_fragment, container, false)
        s = SharedPref(requireActivity())
        btn_Logout = view.findViewById(R.id.btn_logout)
        tv_nama = view.findViewById(R.id.tv_nama_account)
        tv_email = view.findViewById(R.id.tv_email_account)

        tv_nama.text = s.getString(s.nama)
        tv_email.text = s.getString(s.email)

        btn_Logout.setOnClickListener {
            s.setStatusLogin(false)
            val i = Intent(context, LoginActivity::class.java)
            startActivity(i)
        }

        return view
    }


}