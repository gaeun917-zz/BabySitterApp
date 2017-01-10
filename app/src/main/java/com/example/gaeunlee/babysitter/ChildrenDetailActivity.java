package com.example.gaeunlee.babysitter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.gaeunlee.babysitter.sitter.SitterBookActivity;

public class ChildrenDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_detail);


        Button login = (Button) findViewById(R.id.btnBookSitter_baby_detail);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                final Children children = new Children();
//
//                TextView firstName = (TextView) findViewById(R.id.child_name_baby);
//                firstName.setText(children.getFirst_name());
//
//                TextView bdayView = (TextView) findViewById(R.id.birthday_baby2);
//                bdayView.setText(children.getBirthday());
//
////        TextView interestView = (TextView) findViewById(R.id.interest_baby2);
////        interestView.setText((CharSequence) children.getInterest());
////        TextView bedView = (TextView) findViewById(R.id.bed_time_baby2);
////        bedView.setText(children.getBed_time());
////        TextView bathView = (TextView) findViewById(R.id.bath_bed_time_baby2);
////        bathView.setText(children.getBath_time());
//
//                ImageView iv = (ImageView) findViewById(R.id.image_baby);
//                Bitmap bitmap = getBitmapFromAsset(children.getGender());
//                iv.setImageBitmap(bitmap);
//
//                SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
//                children.setMother_no(pref.getInt("motherNo", 0));
//
//                Gson gson = new Gson();
//                final String json = gson.fromJson(children, Children.class);
//
//                (new Thread() {
//                    public void run() {
//                        try {
//
//                            URL url = new URL("http://192.168.13.18:8088/babySitter/account/login.action");
//                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                            conn.setRequestMethod("GET");
//                            conn.setDoOutput(true);//보내는 메시지 본문에 데이터 쓰기 설정
//                            conn.setDoInput(true);//사용자에게  받는 메시지 읽기 설정
//                            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//
//
////                            //POST: 데이터 받아서 저장
////                            OutputStream ostream = conn.getOutputStream();
////                            ostream.write(("email=" + email.getText().toString() +
////                                    "&password=" + password.getText().toString()).getBytes("utf-8"));
////                            ostream.flush();//미전송 데이터 강제 전송
////                            ostream.close();
//
//                            conn.getResponseCode();
//
//                            //GET:뿌려줄때, 리스트로
//                            InputStream istream = conn.getInputStream();//요청 + 응답수신
//                            InputStreamReader reader = new InputStreamReader(istream);
//                            BufferedReader bf = new BufferedReader(reader);
//                            String responeStr = bf.readLine().toString();
//                            System.out.println(responeStr);
//
//
//                        }
//
//                    }
//
//
//                }).start();
//            }
//
//
//        });
//
//
//    private Bitmap getBitmapFromAsset(String gender) {
//        AssetManager assetManager = getAssets();
//        InputStream stream = null;
//
//        try {
//            stream = assetManager.open(gender + ".png");
//            return BitmapFactory.decodeStream(stream);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//
    Intent intent = new Intent(ChildrenDetailActivity.this, SitterBookActivity.class);
    startActivity(intent);

            }
        });

}
}
