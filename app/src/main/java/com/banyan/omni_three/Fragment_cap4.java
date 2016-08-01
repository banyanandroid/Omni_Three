package com.banyan.omni_three;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Fragment_cap4 extends Fragment {
    int fragVal;
    ImageView next, prev, cap4_img;

    public static Fragment_cap4 init(int val) {
        Fragment_cap4 fragment_cap4 = new Fragment_cap4();
        // Supply val input as an argument.
        Bundle args = new Bundle();
        args.putInt("val", val);
        fragment_cap4.setArguments(args);
        return fragment_cap4;
    }

    View layoutView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragVal = getArguments() != null ? getArguments().getInt("val") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layoutView = inflater.inflate(R.layout.fragment_laycap4, container,
                false);
        next = (ImageView) layoutView.findViewById(R.id.next_img);
        prev = (ImageView) layoutView.findViewById(R.id.prev_img);
        cap4_img = (ImageView) layoutView.findViewById(R.id.cap4_img);
        TextView text_no = (TextView) layoutView.findViewById(R.id.text_no);
        text_no.setText("5");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment_cap5 fragment_cap5 = new Fragment_cap5();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_cap4, fragment_cap5);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment_Video1 fragment_Video1 = new Fragment_Video1();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_cap4, fragment_Video1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        cap4_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment_cap4img fragment_cap4img = new Fragment_cap4img();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_cap4, fragment_cap4img);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return layoutView;
    }


}