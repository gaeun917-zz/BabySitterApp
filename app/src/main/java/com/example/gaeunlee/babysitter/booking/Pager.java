package com.example.gaeunlee.babysitter.booking;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


//Extending FragmentStatePagerAdapter
public class Pager extends FragmentStatePagerAdapter {



    //integer to count number of tabs
    int tabCount;



    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }



    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {



            case 0:
                Fragment01 tab1 = new Fragment01();
                return tab1;





            case 1:
                Fragment02 tab2 = new Fragment02();
                return tab2;





            case 2:
                Fragment03 tab3 = new Fragment03();
                return tab3;





            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}
