package com.example.gaeunlee.babysitter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.gaeunlee.babysitter.booking.BookingHistoryActivity;
import com.example.gaeunlee.babysitter.dto.Children;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int MENU_ITEM_LOGOUT = 1001;
    public static final String FIRST_NAME = "first_name";
    private static final int DETAIL_REQUEST = 1111;
    public static final String RETURN_MESSAGE = "RETURN_MESSAGE";
    private static String webUrl = "https://www.facebook.com";
    private static String email = "info@hbabysitter.com";

    private List<Children> childLists = ChildrenDataProvider.childList;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
//        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);






        Button login = (Button) findViewById(R.id.btnAddChild);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddChildActivity.class);
                startActivity(intent);
            }
        });







//       --------------- Drawer-------------------------------------------------------
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


//       --------------- List View --------------------------------------------------------------

//      xml아이템 리소스
      //  String[] items = getResources().getStringArray(R.array.child);

// 리스트 뷰에 아이 리스트 보여주기!!!!!!
        ChildrenListAdapter adapter = new ChildrenListAdapter(MainActivity.this, R.layout.list_item, childLists);

        // activity_ㅡmain에 content_main (listview) include
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, ChildrenDetailActivity.class);

                Children children = childLists.get(position);
                intent.putExtra(FIRST_NAME, children.getFirst_name());

                startActivityForResult(intent, DETAIL_REQUEST);
            }
        });
//
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//
//        menu.add(0, MENU_ITEM_LOGOUT, 1001, R.string.logout);

        return true;
    }






    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        switch (id) {
//
////
//            case R.id.action_settings:
//                Snackbar.make(coordinatorLayout,
//                        "You selected settings", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                return true;
//
////           BabySitter 앱에 대해서
//            case R.id.action_about:
//                Intent intent = new Intent(this, AboutActivity.class);
//                startActivity(intent);
//                return true;
//
//
////            BabySitter Facebook page로 이동
//            case R.id.action_web:
//                //Go to the website
//                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl));
//                if (webIntent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(webIntent);
//                }
//                return true;
//
//
//            case R.id.action_cart:
//                Snackbar.make(coordinatorLayout,
//                        "You selected the Shopping Cart", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                return true;
//
//
//            case MENU_ITEM_LOGOUT:
//                Snackbar.make(coordinatorLayout,
//                        "You selected Logout", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                return true;
//        }

        return super.onOptionsItemSelected(item);
    }






    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // detailActivity에서 받는 DetailReeust(1111)과 반환하는 ResultOk가 잘 오갔으면 다음을 실행
//
//        if (requestCode == DETAIL_REQUEST) {
//            if (resultCode == RESULT_OK) {
//                String message = data.getStringExtra(RETURN_MESSAGE);
//
//                // 스넥바로 메세지 보여주고 "go to cart"클릭하면 토스트 보여줌
//                Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG).setAction("Go to Cart", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        // intent로 쇼핑카트 페이지로 이동 할 수 있게 해야함, 현재는 클릭하면 토스트 메세지만 보여주게 default setting
//
//                        Toast.makeText(MainActivity.this, "go to cart", Toast.LENGTH_SHORT).show();
//                    }
//                }).show();
//            }
//        }


    }






    //       --------------- Drawer---------------------------------------------------------
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Send an email
        String[] addresses = {email};

        switch (id) {

            case R.id.nav_my_child:










                return true;




            case R.id.nav_booking_history:

                Intent intent4 = new Intent(this, BookingHistoryActivity.class);
                startActivity(intent4);
                return true;


            case R.id.nav_update_profile:


                return true;


            case R.id.nav_payment:

                // payment info가 DB에 있으면, PaymentInfoActivity 보여주고
                // 없으면 PaymentInsertActivity

                Intent intent = new Intent(this, PaymentInsertActivity.class);
                startActivity(intent);

                return true;


            case R.id.nav_about:
                Intent intent2 = new Intent(this, AboutActivity.class);
                startActivity(intent2);

                return true;

            case R.id.nav_share:
                /* Go to the website */
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl));
                if (webIntent.resolveActivity(getPackageManager()) != null)
                    startActivity(webIntent);
                return true;

            case R.id.nav_send:

                Intent intent3 = new Intent(Intent.ACTION_SENDTO);
                intent3.setData(Uri.parse("mailto:"));
                intent3.putExtra(Intent.EXTRA_EMAIL, addresses);
                intent3.putExtra(Intent.EXTRA_SUBJECT, "Information request");
                intent3.putExtra(Intent.EXTRA_TEXT, "Please send some information!");
                startActivity(intent3);
                return true;


            case R.id.nav_logout:


                return true;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//       --------------- Drawer-------------------------------------------------------------------

}
