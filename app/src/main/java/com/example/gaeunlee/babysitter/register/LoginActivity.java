package com.example.gaeunlee.babysitter.register;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gaeunlee.babysitter.MainActivity;
import com.example.gaeunlee.babysitter.R;
import com.example.gaeunlee.babysitter.dto.Mother;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText email = (EditText) findViewById(R.id.email);
        final EditText password = (EditText) findViewById(R.id.password);

        Button login = (Button) findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                (new Thread() {
                    public void run() {
                        try {

                            URL url = new URL("http://192.168.13.18:8088/babySitter/account/login.action");
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setRequestMethod("POST");
                            conn.setDoOutput(true);//보내는 메시지 본문에 데이터 쓰기 설정
                            conn.setDoInput(true);//사용자에게  받는 메시지 읽기 설정
                            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");


                            //POST: 데이터 받아서 저장
                            OutputStream ostream = conn.getOutputStream();
                            ostream.write(("email=" + email.getText().toString() +
                                    "&password=" + password.getText().toString()).getBytes("utf-8"));

                            ostream.flush();//미전송 데이터 강제 전송
                            ostream.close();


                            conn.getResponseCode();

                            //GET:뿌려줄때, 리스트로
                            InputStream istream = conn.getInputStream();//요청 + 응답수신
                            InputStreamReader reader = new InputStreamReader(istream);
                            BufferedReader bf = new BufferedReader(reader);
                            String responeStr = bf.readLine().toString();
                            System.out.println(responeStr);

                            Gson gson = new Gson();
                            final Mother mother = gson.fromJson(responeStr, Mother.class);


                            if (responeStr != null) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {


                                        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = pref.edit();
                                        editor.putString("Email", mother.getEmail());
                                        editor.putInt("motherNo", mother.getMother_no());
                                        editor.commit();


                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                });

                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                }).start();
            }
        });


//      To Term Page
        Button term = (Button) findViewById(R.id.btnTerm);
        term.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, TermActivity.class);
                startActivity(intent);
            }
        });


//      Register process To Register Page
        Button register = (Button) findViewById(R.id.btnLinkToRegisterScreen);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


    }
}
