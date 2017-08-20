package com.timposu.aplikasipembayaran.restclient;

import android.util.Log;

import com.timposu.aplikasipembayaran.exception.GagalLoginException;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ucup on 03/08/17.
 */

public class PembayaranClient  {
    private static final String URL_SERVER = "https://pembayaran-server.herokuapp.com";
    private RestTemplate restTemplate = new RestTemplate();

    public void login(String username, String password) throws GagalLoginException {
        Map<String, String> loginData = new HashMap<>();
        loginData.put("username", username);
        loginData.put("password", password);

        Map<String, Object> hasil = restTemplate.
                postForObject(URL_SERVER + "/api/login", loginData, Map.class, new Object[]{});

        Log.d("Psan", hasil.toString());

        if ( hasil == null ) {
            throw new GagalLoginException("Response Invalid");
        }
        if ( !(Boolean) hasil.get("success") ) {
            throw new GagalLoginException("Username / Password salah");
        }
    }
}
