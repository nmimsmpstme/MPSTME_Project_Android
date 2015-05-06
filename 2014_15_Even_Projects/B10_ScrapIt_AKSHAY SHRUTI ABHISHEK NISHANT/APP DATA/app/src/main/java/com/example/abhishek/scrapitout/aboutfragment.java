package com.example.abhishek.scrapitout;

/**
 * Created by Abhishek on 25/03/2015.
 */
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loginscreen.R;

@SuppressLint("NewApi")

public class aboutfragment extends Fragment{
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater .inflate(R.layout.about_fragment, container, false);
        return rootView;
    }
}
