package com.inyongtisto.tokoonline.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inyongtisto.tokoonline.R
import com.inyongtisto.tokoonline.helper.Helper
import kotlinx.android.synthetic.main.toolbar.*

class TambahAlamatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_alamat)
        Helper().setToolbar(this, toolbar, "Tambah Alamat")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
