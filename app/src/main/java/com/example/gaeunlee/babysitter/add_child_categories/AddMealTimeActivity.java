package com.example.gaeunlee.babysitter.add_child_categories;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.gaeunlee.babysitter.R;

public class AddMealTimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal_time);
    }



    // 버튼 온클릭으로 xml에서 주어진 값 :
    public void showTimePickerDialog1(View v) {
        DialogFragment newFragment = new TimePickerMeal();
        newFragment.show(getSupportFragmentManager(), "timePicker1");
    }

    public void showTimePickerDialog2(View v) {
        DialogFragment newFragment = new TimePickerMeal();
        newFragment.show(getSupportFragmentManager(), "timePicker2");
    }


    public void showTimePickerDialog3(View v) {
        DialogFragment newFragment = new TimePickerMeal();
        newFragment.show(getSupportFragmentManager(), "timePicker3");
    }

}

