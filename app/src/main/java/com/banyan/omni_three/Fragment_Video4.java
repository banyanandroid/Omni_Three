package com.banyan.omni_three;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class Fragment_Video4 extends Fragment {
    int fragVal;
    MediaPlayer player;
    AssetFileDescriptor afd;
    ImageView img, prev, next;
    VideoView video;

    public static Fragment_Video4 init(int val) {
        Fragment_Video4 truitonFrag = new Fragment_Video4();
        // Supply val input as an argument.
        Bundle args = new Bundle();
        args.putInt("val", val);
        truitonFrag.setArguments(args);
        return truitonFrag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragVal = getArguments() != null ? getArguments().getInt("val") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__layvideo1, container,
                false);
        // MediaController mc= new MediaController(getActivity());

        video = (VideoView) view.findViewById(R.id.videoView);
        img = (ImageView) view.findViewById(R.id.img);
        prev = (ImageView) view.findViewById(R.id.prev);
        next = (ImageView) view.findViewById(R.id.next);
        final MediaController mc = new MediaController(getActivity());

        final ImageView play = (ImageView) view.findViewById(R.id.play);

        img.setImageResource(R.drawable.v4_img);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setVisibility(View.GONE);
                play.setVisibility(View.GONE);
                String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.v4;
                video.setVideoURI(Uri.parse(path));
                video.setMediaController(mc);
                video.start();

            }
        });
        next.setVisibility(View.INVISIBLE);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment_cap8 fragment_cap8 = new Fragment_cap8();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.v1, fragment_cap8);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        return view;
    }














































}