package com.timposu.aplikasipembayaran.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ucup on 7/29/17.
 */

public class Tagihan {
    
    private String namaProduk;
    private String nomorPelanggan;
    private String namaPelanggan;
    private Date bulanTagihan;
    private Date jatuhTempo;
    private BigDecimal nilai;

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    public void setNomorPelanggan(String nomorPelanggan) {
        this.nomorPelanggan = nomorPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public Date getBulanTagihan() {
        return bulanTagihan;
    }

    public void setBulanTagihan(Date bulanTagihan) {
        this.bulanTagihan = bulanTagihan;
    }

    public Date getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(Date jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

    public BigDecimal getNilai() {
        return nilai;
    }

    public void setNilai(BigDecimal nilai) {
        this.nilai = nilai;
    }
}
