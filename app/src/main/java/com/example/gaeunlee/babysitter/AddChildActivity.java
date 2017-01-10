package com.example.gaeunlee.babysitter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.gaeunlee.babysitter.add_child_categories.AddAllergiesActivity;
import com.example.gaeunlee.babysitter.add_child_categories.AddBathAndBedTimeActivity;
import com.example.gaeunlee.babysitter.add_child_categories.AddInterestActivity;
import com.example.gaeunlee.babysitter.add_child_categories.AddMealTimeActivity;
import com.example.gaeunlee.babysitter.dto.Children;
import com.google.gson.Gson;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class AddChildActivity extends Activity {

    private List<Children> childLists = ChildrenDataProvider.childList;
    public static final String FIRST_NAME = "first_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);


        Button login2 = (Button) findViewById(R.id.demo);
        login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               final Children children = new Children();

                EditText first_name = (EditText) findViewById(R.id.first_name);
                children.setFirst_name(first_name.getText().toString());


                EditText last_name = (EditText) findViewById(R.id.last_name);
                children.setLast_name (last_name.getText().toString());

                EditText Birthday_add_child = (EditText) findViewById(R.id.Birthday_add_child);
                children.setBirthday(Birthday_add_child.getText().toString());

                RadioGroup child_gender = (RadioGroup) findViewById(R.id.child_gender);
                children.setGender(((RadioButton)findViewById(child_gender.getCheckedRadioButtonId())).getText().toString());

                SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
                children.setMother_no(pref.getInt("motherNo", 0));

                Gson gson = new Gson();
                final String json = gson.toJson(children);

                (new Thread() {
                    public void run() {
                        try {

                            URL url = new URL("http://192.168.13.18:8088/babySitter/children/insert1.action");
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setRequestMethod("POST");
                            conn.setDoOutput(true);//전송 메시지 본문에 데이터 쓰기 설정
                            conn.setDoInput(true);//수신 메시지 읽기 설정
                            conn.setRequestProperty("Content-Type", "application/json");

                            //전송 데이터 쓰기 :Post
                            OutputStream ostream = conn.getOutputStream();
                            ostream.write(json.getBytes("utf-8"));
                            ostream.flush();//미전송 데이터 강제 전송
                            ostream.close();


                            conn.getResponseCode();

                            Intent intent = new Intent(AddChildActivity.this, MainActivity.class);
                            startActivity(intent);


                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }).start();
            }
        });



//버튼 눌렀을떄 각각 데이터 받아와서 텍스트 뷰에 표시해서 그 텍스트를 가져옴: time이랑 같게 하면됨
        Button interest = (Button) findViewById(R.id.btnInterest);
        interest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddChildActivity.this, AddInterestActivity.class);
                startActivity(intent);
            }
        });


        Button mealTime = (Button) findViewById(R.id.btnMealTime);
        mealTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddChildActivity.this, AddMealTimeActivity.class);
                startActivity(intent);
            }
        });

        Button bathAndBed = (Button) findViewById(R.id.btnBathandBed);
        bathAndBed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddChildActivity.this, AddBathAndBedTimeActivity.class);
                startActivity(intent);
            }
        });

        Button Allergies = (Button) findViewById(R.id.btnAllergies);
        Allergies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddChildActivity.this, AddAllergiesActivity.class);
                startActivity(intent);
            }
        });






//   ---------------데이터 소스 어레이 겟 -----------------------------------------

//
////       --------------- List View --------------------------------------------------------------
//
////      xml아이템 리소스
//        //  String[] items = getResources().getStringArray(R.array.child);
//
//        ChildrenListAdapter adapter = new ChildrenListAdapter(
//                AddChildActivity.this, R.layout.list_item, childLists);
//
//        // activity_ㅡmain에 content_main (listview) include
//        ListView lv = (ListView) findViewById(R.id.listView);
//        lv.setAdapter(adapter);
//
//        lv.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                        Intent intent = new Intent(MainActivity.this, ChildrenDetailActivity.class);
//
//                        Children children = childLists.get(position);
//                        intent.putExtra(FIRST_NAME, children.getFirst_name());
//
//                        startActivityForResult(intent, DETAIL_REQUEST);
//                    }
//                });
//
//
////   ---------------데이터 소스 어레이 겟 -----------------------------------------
//
//
    }

}