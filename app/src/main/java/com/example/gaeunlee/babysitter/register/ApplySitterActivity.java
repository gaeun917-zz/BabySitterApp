package com.example.gaeunlee.babysitter.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.gaeunlee.babysitter.R;
import com.example.gaeunlee.babysitter.dto.Age;
import com.example.gaeunlee.babysitter.dto.Sitter;
import com.example.gaeunlee.babysitter.dto.Skill;
import com.google.gson.Gson;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApplySitterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_sitter);


        Button babysitter = (Button) findViewById(R.id.btnApply);
        babysitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Sitter sitter = new Sitter();
                Skill skill = new Skill();
                Age age = new Age();

                //gender: radiobutton, 숫자로 받을때는  Integer.parseInt

                EditText sitter_name = (EditText) findViewById(R.id.sitter_name);
                sitter.setName(sitter_name.getText().toString());

                EditText sitter_age = (EditText) findViewById(R.id.sitter_age);
                sitter.setSitter_age(Integer.parseInt(sitter_age.getText().toString()));

                EditText sitter_school = (EditText) findViewById(R.id.sitter_school);
                sitter.setSchool(sitter_school.getText().toString());

                EditText sitter_email = (EditText) findViewById(R.id.sitter_email);
                sitter.setEmail(sitter_email.getText().toString());

                EditText sitter_address = (EditText) findViewById(R.id.sitter_address);
                sitter.setAddress(sitter_address.getText().toString());

                RadioGroup sitter_gender = (RadioGroup) findViewById(R.id.sitter_gender);
                sitter.setGender(((RadioButton)findViewById(sitter_gender.getCheckedRadioButtonId())).getText().toString());
//age table 내용을 넣으려함!
                RadioGroup ageGroup = (RadioGroup) findViewById(R.id.ageGroup);
                age.setAge_type(((RadioButton)findViewById(ageGroup.getCheckedRadioButtonId())).getText().toString());

                RadioGroup apply_sitter_quality = (RadioGroup) findViewById(R.id.apply_sitter_quality);
                sitter.setSitter_quality(((RadioButton)findViewById(apply_sitter_quality.getCheckedRadioButtonId())).getText().toString());

                EditText sitter_note = (EditText) findViewById(R.id.sitter_note);
                sitter.setBio(sitter_note.getText().toString());

                Gson gson = new Gson();
                final String json = gson.toJson(sitter);



                (new Thread() {
                    public void run() {
                        try {

                            URL url = new URL("http://192.168.13.18:8088/babySitter/sitter/apply.action");
                            URL url2 = new URL("http://192.168.13.18:8088/babySitter/sitter/apply2.action");
//                            URL url3 = new URL("http://192.168.13.18:8088/babySitter/sitter/apply3.action");

                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
//                            HttpURLConnection conn3 = (HttpURLConnection) url3.openConnection();

                            conn2.setRequestMethod("POST");
                            conn2.setDoOutput(true);//전송 메시지 본문에 데이터 쓰기 설정
                            conn2.setDoInput(true);//수신 메시지 읽기 설정
                            conn2.setRequestProperty("Content-Type", "application/json");

//                            conn3.setRequestMethod("POST");
//                            conn3.setDoOutput(true);//전송 메시지 본문에 데이터 쓰기 설정
//                            conn3.setDoInput(true);//수신 메시지 읽기 설정
//                            conn3.setRequestProperty("Content-Type", "application/json");

                            conn.setRequestMethod("POST");
                            conn.setDoOutput(true);//전송 메시지 본문에 데이터 쓰기 설정
                            conn.setDoInput(true);//수신 메시지 읽기 설정
                            conn.setRequestProperty("Content-Type", "application/json");


                            //전송 데이터 쓰기
                            OutputStream ostream = conn.getOutputStream();
                            ostream.write(json.getBytes("utf-8"));
                            ostream.flush();//미전송 데이터 강제 전송
                            ostream.close();

                            conn.getResponseCode();

                            Intent intent = new Intent(ApplySitterActivity.this, ConfirmApplyActivity.class);
                            startActivity(intent);

                        } catch (Exception e) {
                            throw new RuntimeException(e);

                        }
                    }
                }).start();
            }
        });
    }
}
