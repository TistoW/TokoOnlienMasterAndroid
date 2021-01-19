package com.inyongtisto.tokoonline.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inyongtisto.tokoonline.R
import com.inyongtisto.tokoonline.helper.Helper
import kotlinx.android.synthetic.main.activity_pengiriman.*
import kotlinx.android.synthetic.main.toolbar.*

class PengirimanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengiriman)
        Helper().setToolbar(this, toolbar, "Pengiriman")

        mainButton()
    }

    private fun mainButton(){
        btn_tambahAlamat.setOnClickListener {
            startActivity(Intent(this, ListAlamatActivity::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
