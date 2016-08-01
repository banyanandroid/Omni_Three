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


public class Fragment_7 extends Fragment {
    int fragVal;
    ImageView next, prev;
    TextView pt1,pt2,pt3,pt4;

    public static Fragment_7 init(int val) {
        Fragment_7 frag_7 = new Fragment_7();
        // Supply val input as an argument.
        Bundle args = new Bundle();
        args.putInt("val", val);
        frag_7.setArguments(args);
        return frag_7;
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
        layoutView = inflater.inflate(R.layout.fragment_lay7, container,
                false);
        next = (ImageView) layoutView.findViewById(R.id.next_img);
        prev = (ImageView) layoutView.findViewById(R.id.prev_img);


        TextView text_no = (TextView) layoutView.findViewById(R.id.text_no);
        text_no.setText("7");

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment_6 fragment_6 = new Fragment_6();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag7, fragment_6);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment_8 fragment_8 = new Fragment_8();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag7, fragment_8);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        /*img_frag10.postDelayed(new Runnable() {
            public void run() {
                img_frag10.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.ZoomInLeft)
                        .duration(1000)
                        .playOn(layoutView.findViewById(R.id.img_frag10));
            }
        }, 500);*/

        return layoutView;
    }


}