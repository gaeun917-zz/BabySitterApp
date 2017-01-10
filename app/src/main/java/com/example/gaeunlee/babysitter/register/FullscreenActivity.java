package com.example.gaeunlee.babysitter.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.gaeunlee.babysitter.R;


public class FullscreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

//      To Mother Login
        Button babymama = (Button) findViewById(R.id.iam_babymama_button);
        babymama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FullscreenActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


//      To BabySitter Reigster
        Button babysitter = (Button) findViewById(R.id.iam_babysitter_button);
        babysitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FullscreenActivity.this, ApplySitterActivity.class);
                startActivity(intent);
            }
        });




    }
}