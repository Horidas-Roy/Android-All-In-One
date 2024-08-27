package com.horidas.navigationdrawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HomeFragment extends Fragment {
    private static final String ARG1 = "argument1";
    private static final String ARG2 = "argument2";

    public HomeFragment() {
        // Required empty public constructor
    }

    //for data passing in argument
    public static HomeFragment getInstance(String value1,int value2){
        HomeFragment homeFragment = new HomeFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ARG1,value1);
        bundle.putInt(ARG2,value2);
        homeFragment.setArguments(bundle);

        return homeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if(getArguments() != null){
//            String name = getArguments().getString("name");
//            int Roll_No = getArguments().getInt("Age");

            String name = getArguments().getString(ARG1);
            int Roll_No = getArguments().getInt(ARG2);

            Log.d("Values from Argument","Name is "+name+",roll no is "+Roll_No);
        }

        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}