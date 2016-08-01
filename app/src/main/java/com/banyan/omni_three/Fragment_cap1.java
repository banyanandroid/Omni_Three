package com.banyan.omni_three;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Fragment_cap1 extends Fragment {
    int fragVal;
    ImageView next, prev;

    public static Fragment_cap1 init(int val) {
        Fragment_cap1 fragment_cap1 = new Fragment_cap1();
        // Supply val input as an argument.
        Bundle args = new Bundle();
        args.putInt("val", val);
        fragment_cap1.setArguments(args);
        return fragment_cap1;
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
        layoutView = inflater.inflate(R.layout.fragment_laycap1, container,
                false);
        next = (ImageView) layoutView.findViewById(R.id.next_img);

        TextView tv = (TextView) layoutView.findViewById(R.id.cap1_txt4);
        Typeface face = Typeface.createFromAsset(getContext().getAssets(),"Bubblegum.ttf");//(getAssets(), "fonts/logo_txt.ttf");
        tv.setTypeface(face);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment_cap2 fragment_cap2 = new Fragment_cap2();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_cap1, fragment_cap2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        

        return layoutView;
    }


}