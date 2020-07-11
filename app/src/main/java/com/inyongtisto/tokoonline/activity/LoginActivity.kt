package com.inyongtisto.tokoonline.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inyongtisto.tokoonline.R
import com.inyongtisto.tokoonline.helper.SharedPref
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        s = SharedPref(this)

        btn_prosesLogin.setOnClickListener {
            s.setStatusLogin(true)
        }
    }
}
