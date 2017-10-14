package com.example.android.so;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity implements OnClickListener{

    Button rgs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rgs = (Button) findViewById(R.id.register_button);
        rgs.setOnClickListener(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){

        if (keyCode == KeyEvent.KEYCODE_BACK){
            onBackPressed();
        }
        return super.onKeyDown(keyCode, event);

    }

    public void onBackPressed(){
        Intent myIntent = new Intent(RegisterActivity.this, WelcomeActivity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(myIntent);
        finish();
        return;
    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(i);

    }
}
