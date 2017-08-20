package com.timposu.aplikasipembayaran.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.timposu.aplikasipembayaran.R;
import com.timposu.aplikasipembayaran.adapter.TagihanAdapter;
import com.timposu.aplikasipembayaran.dao.TagihanDao;
import com.timposu.aplikasipembayaran.domain.Tagihan;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by ucup on 7/29/17.
 */

public class DashboardFragment extends Fragment{

    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_dashboard, container, false);

        TagihanDao tagihanDao = new TagihanDao(getContext());
        List<Tagihan> dataTagihan = tagihanDao.semuaTagihan();
        BigDecimal total = BigDecimal.ZERO;
        for (Tagihan t : dataTagihan){
            total = total.add(t.getNilai());
        }

        TextView totalTagihan = (TextView) view.findViewById(R.id.txtDashBoard);
        totalTagihan.setText(NumberFormat.getCurrencyInstance(new Locale("id", "id")).format(total));

            ListView lvTagihan = (ListView) view.findViewById(R.id.lvTagihan);
        lvTagihan.setAdapter(new TagihanAdapter(getContext(), R.layout.lv_daftar_tagihan,
                tagihanDao.semuaTagihan()));

        return view;
    }
}
