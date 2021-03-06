package com.timposu.aplikasipembayaran.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.timposu.aplikasipembayaran.R;

/**
 * Created by ucup on 21/07/17.
 */

public class CekTagihanFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fr_cek_tagihan, container, false);

        Button btnTagihan;
        btnTagihan = (Button) fragmentView.findViewById(R.id.btTagihan);

        btnTagihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = CekTagihanFragment.this.getActivity()
                        .getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_sebelum_login, new HasilTagihanFragment());
                transaction.commit();
            }
        });

        return fragmentView;
    }
}
