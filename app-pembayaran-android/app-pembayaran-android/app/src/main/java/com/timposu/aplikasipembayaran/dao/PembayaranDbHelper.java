package com.timposu.aplikasipembayaran.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ucup on 7/31/17.
 */

public class PembayaranDbHelper extends SQLiteOpenHelper {

    // Buat tabel
    private static final String SQL_CREATE_TAGIHAN =
            "CREATE TABLE " + SkemaDatabasePembayaran.TabelTagihan.TABLE_NAME + " (" +
                    SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_IDTAGIHAN + " INTEGER PRIMARY KEY," +
                    SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NAMA_PRODUK + " TEXT," +
                    SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NOMOR_PELANGGAN + " TEXT," +
                    SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NAMA_PELANGGAN + " TEXT," +
                    SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_BULAN_TAGIHAN + " TEXT," +
                    SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_JATUH_TEMPO + " TEXT," +
                    SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NILAI + " REAL)";

    // Hapus tabel
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SkemaDatabasePembayaran.TabelTagihan.TABLE_NAME;


    public PembayaranDbHelper(Context context) {
        super(context, SkemaDatabasePembayaran.DATABASE_NAME,
                null, SkemaDatabasePembayaran.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TAGIHAN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
