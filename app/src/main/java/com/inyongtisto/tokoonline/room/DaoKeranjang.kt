package com.inyongtisto.tokoonline.room

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.inyongtisto.tokoonline.model.Produk

@Dao
interface DaoKeranjang {

    @Insert(onConflict = REPLACE)
    fun insert(data: Produk)

    @Delete
    fun delete(data: Produk)

    @Update
    fun update(data: Produk): Int

    @Query("SELECT * from keranjang ORDER BY id ASC")
    fun getAll(): List<Produk>

    @Query("SELECT * FROM keranjang WHERE id = :id LIMIT 1")
    fun getProduk(id: Int): Produk

    @Query("DELETE FROM keranjang")
    fun deleteAll(): Int
}