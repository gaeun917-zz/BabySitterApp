package com.example.gaeunlee.babysitter.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gaeunlee.babysitter.MainActivity;
import com.example.gaeunlee.babysitter.R;
import com.example.gaeunlee.babysitter.dto.Mother;
import com.google.gson.Gson;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//      Register process To Register Page
        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mother mother = new Mother();

                EditText email = (EditText) findViewById(R.id.email);
                mother.setEmail(email.getText().toString());

                EditText password = (EditText) findViewById(R.id.password);
                mother.setPassword(password.getText().toString());

                EditText first_name = (EditText) findViewById(R.id.first_name);
                mother.setFirst_name(first_name.getText().toString());
                EditText last_name = (EditText) findViewById(R.id.last_name);
                mother.setLast_name(last_name.getText().toString());

                EditText address = (EditText) findViewById(R.id.address);
                mother.setAddress(address.getText().toString());
                //EditText phone = (EditText) findViewById(R.id.phone);
                // phone int 인데 어떻게?
//                            int mphone = Integer.parseInt(phone.getText().toString());
//                            mother.setPhone(mphone);
                Gson gson = new Gson();
                final String json = gson.toJson(mother);

                (new Thread() {
                    public void run() {
                        try {

                            URL url = new URL("http://192.168.13.18:8088/babySitter/account/register.action");
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setRequestMethod("POST");
                            conn.setDoOutput(true);//전송 메시지 본문에 데이터 쓰기 설정
                            conn.setDoInput(true);//수신 메시지 읽기 설정
                            conn.setRequestProperty("Content-Type", "application/json");


                            //전송 데이터 쓰기
                            OutputStream ostream = conn.getOutputStream();
                            ostream.write(json.getBytes("utf-8"));//한글일 경우 euc-kr
                            ostream.flush();//미전송 데이터 강제 전송
                            ostream.close();


                            conn.getResponseCode();


                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
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

