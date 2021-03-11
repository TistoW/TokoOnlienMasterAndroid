package com.inyongtisto.tokoonline.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import com.inyongtisto.tokoonline.R
import com.inyongtisto.tokoonline.app.ApiConfig
import com.inyongtisto.tokoonline.model.Chekout
import com.inyongtisto.tokoonline.model.ResponModel
import kotlinx.android.synthetic.main.activity_pembayaran.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PembayaranActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembayaran)

        btn_bca.setOnClickListener {
            bayar("bca")
        }

        btn_BRI.setOnClickListener {
            bayar("bri")
        }

        btn_mandiri.setOnClickListener {
            bayar("mandiri")
        }
    }

    fun bayar(bank: String){

        val json = intent.getStringExtra("extra")!!.toString()
        val chekout =  Gson().fromJson(json, Chekout::class.java)
        chekout.bank = bank

        ApiConfig.instanceRetrofit.chekout(chekout).enqueue(object : Callback<ResponModel> {
            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
//                Toast.makeText(this, "Error:" + t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val respon = response.body()!!
                if (respon.success == 1) {
                    Toast.makeText(this@PembayaranActivity, "Berhasil kirim ke server", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@PembayaranActivity, "Error:" + respon.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}
