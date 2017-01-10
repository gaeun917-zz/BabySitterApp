package com.example.gaeunlee.babysitter.sitter;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaeunlee.babysitter.R;
import com.example.gaeunlee.babysitter.booking.BookingActivity;
import com.example.gaeunlee.babysitter.dto.Sitter;

import java.io.IOException;
import java.io.InputStream;

public class SitterBookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitter_detail);

        String name = getIntent().getStringExtra(SitterBookActivity.NAME);
        Sitter sitter = SitterDataProvider.sitterMap.get(name);

        TextView nameView = (TextView) findViewById(R.id.sitter_name);
        nameView.setText(sitter.getName());

        TextView genderView = (TextView) findViewById(R.id.sitter_gender_book2);
        genderView.setText(sitter.getGender());

        TextView ageView = (TextView) findViewById(R.id.sitter_age_book2);
        ageView.setText(sitter.getSitter_age());


        TextView bioView = (TextView) findViewById(R.id.sitter_bio_book2)  ;
        bioView.setText(sitter.getBio());


        TextView skillsView = (TextView) findViewById(R.id.sitter_skills_book2);
        skillsView.setText(sitter.getSkills());

        TextView qualityView = (TextView) findViewById(R.id.sitter_quality2);
        qualityView.setText(sitter.getSitter_quality());


        ImageView iv = (ImageView) findViewById(R.id.image_sitter);
        Bitmap bitmap = getBitmapFromAsset(sitter.getGender());
        iv.setImageBitmap(bitmap);

        Button booking = (Button) findViewById(R.id.btnBookSitter);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SitterBookDetailActivity.this, BookingActivity.class);
                startActivity(intent);
            }
        });
    }




    private Bitmap getBitmapFromAsset(String gender) {
        AssetManager assetManager = getAssets();
        InputStream stream = null;

        try {
            stream = assetManager.open(gender + ".png");
            return BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    }

