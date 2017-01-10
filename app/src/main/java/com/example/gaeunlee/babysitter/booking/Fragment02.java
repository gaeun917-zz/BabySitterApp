package com.example.gaeunlee.babysitter.booking;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gaeunlee.babysitter.R;



//Our class extending fragment
public class Fragment02 extends Fragment {

	//Overriden method onCreateView
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		//Returning the layout file after inflating
		//Change R.layout.tab1 in you classes
		return inflater.inflate(R.layout.frag02, container, false);
	}
}