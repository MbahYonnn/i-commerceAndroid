package com.app.i_commerce

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.app.i_commerce.activity.LoginActivity
import com.app.i_commerce.fragment.AccountFragment
import com.app.i_commerce.fragment.CartFragment
import com.app.i_commerce.fragment.HomeFragment
import com.app.i_commerce.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    val fragmentHome: Fragment = HomeFragment()
    val fragmentCart: Fragment = CartFragment()
    val fragmentAccount: Fragment = AccountFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragmentHome
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
    private lateinit var BottomNavigationView: BottomNavigationView
    private var statusLogin = false
    private lateinit var s: SharedPref


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        s = SharedPref(this)
        setupBotNav()
    }

    fun setupBotNav(){
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentCart).hide(fragmentCart).commit()
        fm.beginTransaction().add(R.id.container, fragmentAccount).hide(fragmentAccount).commit()

        BottomNavigationView = findViewById(R.id.nav_view)
        menu = BottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        BottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    callFragment(0,fragmentHome)
                }
                R.id.menu_cart -> {
                    callFragment(1,fragmentCart)

                }
                R.id.menu_account -> {
                    if (s.getStatusLogin()){
                        callFragment(2,fragmentAccount)
                    } else{
                        startActivity(Intent(this, LoginActivity::class.java))
                    }

                }
            }
            false
        }
    }

    fun callFragment(int: Int, fragment: Fragment){
        Log.d("respones", "acc")
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}