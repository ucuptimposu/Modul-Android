package com.timposu.aplikasipembayaran.dao;

import android.provider.BaseColumns;

/**
 * Created by ucup on 7/31/17.
 */

public final class SkemaDatabasePembayaran {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Pembayaran.db";

    // Dilarang mengistankan
    // Tidak bisa new SkemaDatabasePembayaran()
    private SkemaDatabasePembayaran() {
    }

    // Inner class untuk mendefinisikan schema tabel tagihan
    public abstract class TabelTagihan implements BaseColumns{
        public static final String TABLE_NAME = "tagihan";
        public static final String COLUMN_NAME_IDTAGIHAN = "IDTagihan";
        public static final String COLUMN_NAME_NAMA_PRODUK = "NamaProduk";
        public static final String COLUMN_NAME_NOMOR_PELANGGAN = "NomorPelanggan";
        public static final String COLUMN_NAME_NAMA_PELANGGAN = "NamaPelanggan";
        public static final String COLUMN_NAME_BULAN_TAGIHAN = "BulanTagihan";
        public static final String COLUMN_NAME_JATUH_TEMPO = "JatuhTempo";
        public static final String COLUMN_NAME_NILAI = "Nilai";
    }
}
