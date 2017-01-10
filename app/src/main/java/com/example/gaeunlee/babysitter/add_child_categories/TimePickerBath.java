package com.example.gaeunlee.babysitter.add_child_categories;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.gaeunlee.babysitter.R;

import java.util.Calendar;


public class TimePickerBath extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {






    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);




        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));


    }




    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {



        // Do something with the time chosen by the user
        TextView tv1=(TextView) getActivity().findViewById(R.id.textView1);
        tv1.setText("목욕시간: "+view.getCurrentHour()+"시 " +view.getCurrentMinute()  +   "분 ");


        TextView tv2=(TextView) getActivity().findViewById(R.id.textView2);
        tv2.setText("자는 시간 : "+view.getCurrentHour()+"시 " +view.getCurrentMinute()  +   "분 ");


    }









}