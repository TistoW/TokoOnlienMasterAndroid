package com.inyongtisto.tokoonline.model;

import java.io.Serializable;

public class Produk implements Serializable {
    public int id;
    public String name;
    public String harga;
    public String deskripsi;
    public int category_id;
    public String image;
    public String created_at;
    public String updated_at;
}
