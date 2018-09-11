package com.ssnahhydev.zexpress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = findViewById(R.id.img_splash);
        textView = findViewById(R.id.tv_splash);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade);
        imageView.startAnimation(animation);
        textView.startAnimation(animation);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    startActivity(new Intent(Splash.this, MainActivity.class));
                    finish();
                    super.run();
                }catch (InterruptedException e){

                }
                super.run();
            }
        };

        thread.start();
    }
}
