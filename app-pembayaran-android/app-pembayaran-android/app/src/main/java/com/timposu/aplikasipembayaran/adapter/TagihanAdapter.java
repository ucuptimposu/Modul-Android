package com.timposu.aplikasipembayaran.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.timposu.aplikasipembayaran.R;
import com.timposu.aplikasipembayaran.domain.Tagihan;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

/**
 * Created by ucup on 7/29/17.
 */

public class TagihanAdapter extends ArrayAdapter<Tagihan> {

    public TagihanAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Tagihan> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.lv_daftar_tagihan, parent, false);
        }

        TextView txtNamaProduk = (TextView) convertView.findViewById(R.id.lblNamaProduk);
        TextView txtNomorPelanggan = (TextView) convertView.findViewById(R.id.lblNomorPelanggan);
        TextView txtNamaPelanggan = (TextView) convertView.findViewById(R.id.lblNamaPelanggan);
        TextView txtBulanTagihan = (TextView) convertView.findViewById(R.id.lblBulanTagihan);
        TextView txtJatuhTempo = (TextView) convertView.findViewById(R.id.lblJatuhTempo);
        TextView txtNilai = (TextView) convertView.findViewById(R.id.lblNilai);

        Tagihan t = getItem(position);
        txtNamaProduk.setText(t.getNamaProduk());
        txtNamaPelanggan.setText(t.getNamaPelanggan());
        txtNomorPelanggan.setText(t.getNomorPelanggan());
        txtBulanTagihan.setText(new SimpleDateFormat("MMMM yyyy").format(t.getBulanTagihan()));
        txtJatuhTempo.setText(new SimpleDateFormat("dd MMMM yyyy").format(t.getJatuhTempo()));

        NumberFormat curencyFormater = NumberFormat.getCurrencyInstance(new Locale("id", "id"));

        txtNilai.setText(curencyFormater.format(t.getNilai()));

        return convertView;
    }
}
