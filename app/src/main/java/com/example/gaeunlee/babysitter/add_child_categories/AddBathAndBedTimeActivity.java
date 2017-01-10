package com.example.gaeunlee.babysitter.add_child_categories;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.gaeunlee.babysitter.R;

public class AddBathAndBedTimeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bath_and_bed_time);

    }

  public void showTimePickerDialog1(View v) {
        DialogFragment newFragment = new TimePickerBath();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }



    public void showTimePickerDialog2(View v) {
        DialogFragment newFragment = new TimePickerBath();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }




    }


