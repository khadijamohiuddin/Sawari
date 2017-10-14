package com.example.android.so;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity implements OnClickListener {

    Button loginBtn;
    Button registerBtn;

    protected static final long TIME_DELAY1 = 5000;
    protected static final long TIME_DELAY2 = 2000;
    TextView myTextView1;
    TextView myTextView2;
    Handler handler=new Handler();
    int i = 0;
    int j = 0;
    String[] array1 = {"A Perfect Ride", "For Students, By Students", "A project of Iqra University Students"};
    String[] array2 = {"Asad Ali(23726)", "Ghulam Mohiuddin(23729)", "Khadija(23774)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //overridePendingTransition(R.drawable.fadein, R.drawable.fadeout);
        //overridePendingTransition(R.drawable.slide_in_right, R.drawable.slide_out_right);
        setContentView(R.layout.activity_welcome);
        myTextView1=(TextView)findViewById(R.id.myTextView1);
        myTextView2=(TextView)findViewById(R.id.myTextView2);
        handler.post(updateTextRunnable1);
        handler.post(updateTextRunnable2);

        loginBtn = (Button) findViewById(R.id.signIn);
        loginBtn.setOnClickListener(this);

        registerBtn = (Button) findViewById(R.id.signUp);
        registerBtn.setOnClickListener(this);
    }

    Runnable updateTextRunnable1=new Runnable(){
        public void run() {
            myTextView1.setText(array1[i]);
            myTextView1.startAnimation(AnimationUtils.loadAnimation(WelcomeActivity.this, android.R.anim.slide_in_left));
            i++;
            if (i == 3)
                i = 0;
            handler.postDelayed(this, TIME_DELAY1);
        }
    };

    Runnable updateTextRunnable2=new Runnable(){
        public void run() {
            myTextView2.setText(array2[j]);
            myTextView2.startAnimation(AnimationUtils.loadAnimation(WelcomeActivity.this, android.R.anim.slide_in_left));
            j++;
            if (j == 3)
                j = 0;
            handler.postDelayed(this, TIME_DELAY2);
        }
    };

    public void onClick(View v){

        switch (v.getId()) {

            case R.id.signIn:
                // do your code
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                //setContentView(R.layout.activity_login);
                Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vb.vibrate(100);
                break;

            case R.id.signUp:
                // do your code
                Intent j = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(j);
                //setContentView(R.layout.activity_register);
                Vibrator vbb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vbb.vibrate(100);
                break;

            default:
                break;
        }

    }


}
