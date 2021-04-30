package com.inyongtisto.tokoonline.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inyongtisto.tokoonline.R
import com.inyongtisto.tokoonline.app.ApiConfig
import com.inyongtisto.tokoonline.helper.Helper
import com.inyongtisto.tokoonline.helper.SharedPref
import com.inyongtisto.tokoonline.model.Produk
import com.inyongtisto.tokoonline.model.ResponModel
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RiwayatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat)
        Helper().setToolbar(this, toolbar, "Riwayat Belanja")

        getRiwayat()
    }

    fun getRiwayat() {

        val id = SharedPref(this).getUser()!!.id
        ApiConfig.instanceRetrofit.getRiwayat(id).enqueue(object : Callback<ResponModel> {
            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                
            }

            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val res = response.body()!!
                if (res.success == 1) {

                }
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
