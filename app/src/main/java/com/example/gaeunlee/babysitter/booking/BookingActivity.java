package com.example.gaeunlee.babysitter.booking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gaeunlee.babysitter.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BookingActivity extends AppCompatActivity {

    final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
    final SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH시 mm분");

    TextView textView0;
    TextView textView1;
    TextView textView2;

    DateTimePickerBooking dateTimePickerMeal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);



        Button btnConfirm = (Button) findViewById(R.id.btn_booking_confirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookingActivity.this, ConfirmBookingActivity.class);
                startActivity(intent);
            }
        });




        textView0 = (TextView) findViewById(R.id.textView0);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);




        // xml 레이아웃에서 정의한 DateTimePicker 객체 참조
        dateTimePickerMeal = (DateTimePickerBooking) findViewById(R.id.dateTimePicker);





        // 이벤트 처리: 리스너: 변경된 시간 설정
        dateTimePickerMeal.setOnDateTimeChangedListener(new DateTimePickerBooking.OnDateTimeChangedListener() {
            public void onDateTimeChanged(DateTimePickerBooking view, int year,
                                          int monthOfYear, int dayOfYear, int hourOfDay, int minute) {


                //현재 날짜와 시간을 표시하기 위핸 Calendar 객체 사용 : get, set
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(year, monthOfYear, dayOfYear, hourOfDay, minute);


                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(year, monthOfYear, dayOfYear, hourOfDay, minute);

                // calendar로 바뀌고 set한 날짜 시간을 dateFormat으로 텍스트뷰에 표시
                textView0.setText(dateFormat.format(calendar1.getTime()));
                textView1.setText(dateFormat2.format(calendar1.getTime()));
                textView2.setText(dateFormat2.format(calendar2.getTime()));


            }
        });




        //처음 앱에 접근했을때 디폴트로 보여줄 현재 시간 텍스트뷰에 표시
        Calendar calendar = Calendar.getInstance();
        calendar.set(dateTimePickerMeal.getYear(), dateTimePickerMeal.getMonth(), dateTimePickerMeal.getDayOfMonth(),
                dateTimePickerMeal.getCurrentHour(), dateTimePickerMeal.getCurrentMinute());
        textView1.setText("시작시간: " + dateFormat2.format(calendar.getTime()));
//        textView2.setText("종료시간: " +dateFormat2.format(calendar.getTime()));


    }
}
