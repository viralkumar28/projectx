package com.example.projectx.Activity;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.projectx.R;

public class splashscreen extends AppCompatActivity {
    private static int Splash=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(splashscreen.this, loginscreen.class);
                startActivity(homeIntent);
                finish();
            }
        },Splash);
    }
}
