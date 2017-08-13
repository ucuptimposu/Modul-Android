package com.timposu.notificationcloudmessagingexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button btnGetToken;
    private static final String TAG = "NOTIFIKASI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textView = (TextView) findViewById(R.id.txtMessage);

        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                String value = getIntent().getExtras().getString(key);
                textView.append("\n" + key + " : " + value);
            }
        }

        this.btnGetToken = (Button) findViewById(R.id.btnToken);

        this.btnGetToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, FirebaseInstanceId.getInstance().getToken());
            }
        });

    }
}
