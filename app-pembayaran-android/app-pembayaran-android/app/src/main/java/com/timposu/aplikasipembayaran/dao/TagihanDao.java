package com.timposu.aplikasipembayaran.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.timposu.aplikasipembayaran.domain.Tagihan;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ucup on 7/29/17.
 */

public class TagihanDao {

    private Context context;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final String TAG = "DB_TAG";

    public TagihanDao(Context context) {
        this.context = context;
    }

    public void insertTagihan(Tagihan t){
        PembayaranDbHelper pembayaranDbHelper = new PembayaranDbHelper(context);

        SQLiteDatabase database = pembayaranDbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NAMA_PRODUK, t.getNamaProduk());
        cv.put(SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NOMOR_PELANGGAN, t.getNomorPelanggan());
        cv.put(SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NAMA_PELANGGAN, t.getNamaPelanggan());
        cv.put(SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_BULAN_TAGIHAN, dateFormat.format(t.getBulanTagihan()));
        cv.put(SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_JATUH_TEMPO, dateFormat.format(t.getJatuhTempo()));
        cv.put(SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NILAI, t.getNilai().doubleValue());

        database.insert(SkemaDatabasePembayaran.TabelTagihan.TABLE_NAME, null, cv);
    }

    public List<Tagihan> semuaTagihan(){
        List<Tagihan> dataTagihan = new ArrayList<>();

        PembayaranDbHelper pembayaranDbHelper = new PembayaranDbHelper(context);
        SQLiteDatabase database = pembayaranDbHelper.getWritableDatabase();

        String[] daftarKolom = {
                SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NAMA_PRODUK,
                SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NOMOR_PELANGGAN,
                SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NAMA_PELANGGAN,
                SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_BULAN_TAGIHAN,
                SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_JATUH_TEMPO,
                SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NILAI
        };

        String urutan = SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_JATUH_TEMPO + " ASC";

        Cursor cursor = database.query(
                SkemaDatabasePembayaran.TabelTagihan.TABLE_NAME,
                daftarKolom,
                null,
                null,
                null,
                null,
                urutan);

        if (cursor.isBeforeFirst()) {
            while (cursor.moveToNext()) {
                Tagihan t = new Tagihan();
                t.setNamaProduk(cursor.getString(0));
                t.setNomorPelanggan(cursor.getString(1));
                t.setNamaPelanggan(cursor.getString(2));
                try {
                    t.setBulanTagihan(dateFormat.parse(cursor.getString(3)));
                    t.setJatuhTempo(dateFormat.parse(cursor.getString(4)));
                } catch (ParseException e) {
                    Log.w(TAG, e.getMessage());
                }

                t.setNilai(new BigDecimal(cursor.getDouble(5)));
                dataTagihan.add(t);
            }
        }

        cursor.close();

        /** Manual Punya*/
//        Tagihan t1 = new Tagihan();
//        t1.setNamaPelanggan("Ucup Timposu");
//        t1.setNamaProduk("PLN Pascabayar");
//        t1.setNomorPelanggan("12345678");
//        t1.setNilai(new BigDecimal("100000.00"));
//
//        try {
//            t1.setBulanTagihan(dateFormat.parse("2017-07-01"));
//            t1.setJatuhTempo(dateFormat.parse("2017-07-20"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }SkemaDatabasePembayaran.TabelTagihan.COLUMN_NAME_NAMA_PRODUK,

//
//        dataTagihan.add(t1);
//
//        Tagihan t2 = new Tagihan();
//        t2.setNamaPelanggan("Danu Wirnoyo");
//        t2.setNamaProduk("Telkom");
//        t2.setNomorPelanggan("1234587988");
//        t2.setNilai(new BigDecimal("600000.00"));
//
//        try {
//            t2.setBulanTagihan(dateFormat.parse("2017-07-01"));
//            t2.setJatuhTempo(dateFormat.parse("2017-07-20"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        dataTagihan.add(t2);
//
//        Tagihan t3 = new Tagihan();
//        t3.setNamaPelanggan("Ucup Timposu");
//        t3.setNamaProduk("PDAM");
//        t3.setNomorPelanggan("12345678");
//        t3.setNilai(new BigDecimal("50000.00"));
//
//        try {
//            t3.setBulanTagihan(dateFormat.parse("2017-07-01"));
//            t3.setJatuhTempo(dateFormat.parse("2017-07-20"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        dataTagihan.add(t3);

        return dataTagihan;
    }

    public void hapusSemuaTagihan(){
        PembayaranDbHelper pembayaranDbHelper = new PembayaranDbHelper(context);
        SQLiteDatabase database = pembayaranDbHelper.getWritableDatabase();

        database.delete(SkemaDatabasePembayaran.TabelTagihan.TABLE_NAME, null, null);

        database.close();
    }
}
