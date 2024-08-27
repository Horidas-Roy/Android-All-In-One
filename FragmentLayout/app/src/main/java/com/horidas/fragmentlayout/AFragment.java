package com.horidas.fragmentlayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AFragment extends Fragment {
    public static final String ARG1 = "argument1";
    public static final String ARG2 = "argument2";


    public AFragment() {
        // Required empty public constructor
    }

    public static AFragment getInstance(String value1, int value2){
      AFragment aFragment = new AFragment();

      Bundle bundle = new Bundle();
      bundle.putString("name","Milon");
      bundle.putString("age","43");
      aFragment.setArguments(bundle);

        return new AFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        //data receive in fragment
        if(getArguments() != null){
            String name = getArguments().getString(ARG1);
            int roll = getArguments().getInt(ARG2);

            Log.d("values from argument","name: "+name+", roll: "+roll);

            //call predefine method from main Activity
            ((MainActivity)getActivity()).CallFromFragment();
        }

        TextView txtFrag = view.findViewById(R.id.txtFrag);

        return view;
    }
}