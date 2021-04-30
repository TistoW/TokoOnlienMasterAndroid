package com.inyongtisto.tokoonline.model

class Transaksi {
    var id = 0
    var bank = ""
    var jasa_pengiriaman = ""
    var kurir = ""
    var name = ""
    var ongkir = ""
    var phone = ""
    var total_harga = ""
    var total_item = ""
    var total_transfer = ""
    var detail_lokasi = ""
    var user_id = ""
    var kode_payment = ""
    var kode_trx = ""
    var kode_unik = 0
    var status = ""
    var expired_at = ""
    var updated_at = ""
    var created_at = ""
    val details = ArrayList<DetailTransaksi>()
}