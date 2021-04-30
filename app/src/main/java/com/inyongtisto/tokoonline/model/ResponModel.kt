package com.inyongtisto.tokoonline.model

class ResponModel {
    var success = 0
    lateinit var message: String
    var user = User()
    var produks: ArrayList<Produk> = ArrayList()
    var transaksis: ArrayList<Transaksi> = ArrayList()

    var rajaongkir = ModelAlamat()
    var transaksi = Transaksi()

    var provinsi: ArrayList<ModelAlamat> = ArrayList()
    var kota_kabupaten: ArrayList<ModelAlamat> = ArrayList()
    var kecamatan: ArrayList<ModelAlamat> = ArrayList()
}