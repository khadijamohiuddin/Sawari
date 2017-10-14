package com.example.android.so;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements OnClickListener {


    Button lgn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lgn = (Button) findViewById(R.id.login_button);
        lgn.setOnClickListener(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed();

        }

        return super.onKeyDown(keyCode, event);
    }

    public void onBackPressed() {
        Intent myIntent = new Intent(LoginActivity.this, WelcomeActivity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);// clear back stack
        overridePendingTransition(R.drawable.animation_enter, R.drawable.animation_leave);
        startActivity(myIntent);
        finish();
        return;
    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(i);

    }
}
