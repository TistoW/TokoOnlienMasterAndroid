package com.inyongtisto.tokoonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.inyongtisto.tokoonline.fragment.AkunFragment
import com.inyongtisto.tokoonline.fragment.HomeFragment
import com.inyongtisto.tokoonline.fragment.KeranjangFragment

class MainActivity : AppCompatActivity() {

    private val fragmentHome: Fragment = HomeFragment()
    private val fragmentKeranjang: Fragment = KeranjangFragment()
    private var fragmentAkun: Fragment = AkunFragment()
    private val fm: FragmentManager = supportFragmentManager
    private var active: Fragment = fragmentHome

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm.beginTransaction().add(R.id.container, fragmentHome, "1").show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentKeranjang, "2").hide(fragmentKeranjang).commit()
        fm.beginTransaction().add(R.id.container, fragmentAkun, "2").hide(fragmentAkun).commit()
    }
}
