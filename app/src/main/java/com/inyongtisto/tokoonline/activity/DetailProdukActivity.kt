package com.inyongtisto.tokoonline.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.inyongtisto.tokoonline.R
import com.inyongtisto.tokoonline.helper.Helper
import com.inyongtisto.tokoonline.model.Produk
import com.inyongtisto.tokoonline.room.MyDatabase
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_detail_produk.*
import kotlinx.android.synthetic.main.toolbar.*

class DetailProdukActivity : AppCompatActivity() {

    lateinit var produk: Produk

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_produk)

        getInfo()
        mainButton()
    }

    fun mainButton() {
        btn_keranjang.setOnClickListener {
            insert()
        }

        btn_favorit.setOnClickListener {
            val myDb: MyDatabase = MyDatabase.getInstance(this)!! // call database
            val listData = myDb.daoKeranjang().getAll() // get All data
            for (note: Produk in listData) {
                println("-----------------------")
                println(note.name)
                println(note.harga)
            }
        }
    }

    fun insert() {
        val myDb: MyDatabase = MyDatabase.getInstance(this)!! // call database
        CompositeDisposable().add(Observable.fromCallable { myDb.daoKeranjang().insert(produk) }
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("respons", "data inserted")
                })
    }

    fun getInfo() {
        val data = intent.getStringExtra("extra")
        produk = Gson().fromJson<Produk>(data, Produk::class.java)

        // set Value
        tv_nama.text = produk.name
        tv_harga.text = Helper().gantiRupiah(produk.harga)
        tv_deskripsi.text = produk.deskripsi

        val img = "http://192.168.43.231/tokoonline/public/storage/produk/" + produk.image
        Picasso.get()
                .load(img)
                .placeholder(R.drawable.product)
                .error(R.drawable.product)
                .resize(400, 400)
                .into(image)

        // setToolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.title = produk.name
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
