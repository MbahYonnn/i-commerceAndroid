package com.app.i_commerce.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.app.i_commerce.R
import com.app.i_commerce.helper.SharedPref
import com.app.i_commerce.viewmodel.AccountViewModel

class AccountFragment : Fragment() {

    companion object {
        fun newInstance() = AccountFragment()
    }

    private lateinit var viewModel: AccountViewModel
    lateinit var s:SharedPref
    lateinit var btn_Logout: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.account_fragment, container, false)
        s = SharedPref(activity!!)
        btn_Logout = view.findViewById(R.id.btn_logout)

        btn_Logout.setOnClickListener {
            s.setStatusLogin(false)
        }

        return view
    }


}