package com.wartono.my;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends BaseActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);
            Handler handler = new Handler();
            handler.postDelayed(() -> {

                startActivity(new Intent(c, LoginActivity.class));
                finish();
            },5000L);
        }

    }