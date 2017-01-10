package com.example.gaeunlee.babysitter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gaeunlee.babysitter.dto.Payment;
import com.google.gson.Gson;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PaymentInsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        Button btnConfirm_card = (Button) findViewById(R.id.btnConfirm_card);
        btnConfirm_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final  Payment payment = new Payment();

                EditText first_name_card = (EditText) findViewById(R.id.first_name_card);
                payment.setFirst_name(first_name_card.getText().toString());

                EditText last_name_card = (EditText) findViewById(R.id.last_name_card);
                payment.setLast_name(last_name_card.getText().toString());

                EditText card_number_card = (EditText) findViewById(R.id.card_number_card);
                payment.setCard_number(Integer.parseInt(card_number_card.getText().toString()));

                EditText expiration_card = (EditText) findViewById(R.id.expiration_card);
                payment.setExpiration(Integer.parseInt(expiration_card.getText().toString()));

                EditText cvv_card = (EditText) findViewById(R.id.cvv_card);
                payment.setCvv(Integer.parseInt(cvv_card.getText().toString()));

                EditText billing_address_card = (EditText) findViewById(R.id.billing_address_card);
                payment.setBilling_address(billing_address_card.getText().toString());

                SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
                payment.setMother_no(pref.getInt("motherNo", 0));

                Gson gson = new Gson();
                final String json = gson.toJson(payment);

                (new Thread() {
                    public void run() {
                        try {

                            URL url = new URL("http://192.168.13.18:8088/babySitter/account/payment.action");
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setRequestMethod("POST");
                            conn.setDoOutput(true);//전송 메시지 본문에 데이터 쓰기 설정
                            conn.setDoInput(true);//수신 메시지 읽기 설정
                            conn.setRequestProperty("Content-Type", "application/json");

                            //전송 데이터 쓰기 :POST
                            OutputStream ostream = conn.getOutputStream();
                            ostream.write(json.getBytes("utf-8"));
                            ostream.flush();//미전송 데이터 강제 전송
                            ostream.close();

                            conn.getResponseCode();

                            Intent intent = new Intent(PaymentInsertActivity.this, MainActivity.class);
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

















