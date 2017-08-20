package com.timposu.aplikasipembayaran.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.timposu.aplikasipembayaran.R;
import com.timposu.aplikasipembayaran.activity.SetelahLogin;
import com.timposu.aplikasipembayaran.exception.GagalLoginException;
import com.timposu.aplikasipembayaran.restclient.PembayaranClient;

/**
 * Created by ucup on 21/07/17.
 */

public class LoginFragment extends Fragment {

    private PembayaranClient pembayaranClient = new PembayaranClient();
    private final String TAG = "Pesan Login";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fr_login, container, false);

        final Button btnLogin = (Button) fragmentView.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etEmail = (EditText) fragmentView.findViewById(R.id.etEmailLogin);
                EditText etPassword = (EditText) fragmentView.findViewById(R.id.etPasswordLogin);

                String username = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (username.trim().isEmpty() || password.trim().isEmpty()) {
                    Toast.makeText(getContext(), "Username / Password harus diisi", Toast.LENGTH_LONG).show();
                    return;
                }

                new AsyncTask<String, Void, Boolean>() {
                    private String errMessage;
                    private ProgressDialog dialog;

                    @Override
                    protected Boolean doInBackground(String... params) {

                        try {
                            Log.d(TAG, "Login : " + params);

                            pembayaranClient.login(params[0], params[1]);
                            return true;
                        }catch (GagalLoginException err){
                            errMessage = err.getMessage();
                            Log.d(TAG, "Login error: " + errMessage);
                            return false;
                        }
                    }

                    @Override
                    protected void onPreExecute() {
                        dialog = ProgressDialog.show(getContext(), "Login", "Sedang Login....", true);
                        btnLogin.setEnabled(false);
                    }

                    @Override
                    protected void onPostExecute(Boolean sukses) {
                        dialog.dismiss();
                        btnLogin.setEnabled(true);
                        Log.d(TAG, "Login Sukses : " + sukses);
                        Log.d(TAG, "Token : " + FirebaseInstanceId.getInstance().getToken());
                        if (sukses) {
                            Intent intentSetelahLogin = new Intent(getContext(), SetelahLogin.class);
                            startActivity(intentSetelahLogin);
                        } else {
                            Toast.makeText(getContext(), errMessage, Toast.LENGTH_LONG).show();
                        }
                    }

                }.execute(username, password);

            }
        });
        return  fragmentView;
    }
}
