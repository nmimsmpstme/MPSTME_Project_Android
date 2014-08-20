package com.example.scoreit;



import com.example.scoreit.angry;
import com.example.scoreit.fifa;
import com.example.scoreit.real;
import com.example.scoreit.office;
import com.example.scoreit.second;
import com.example.scoreit.third;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
 
public class TabAdapter extends FragmentPagerAdapter {
 
    public TabAdapter(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            // Top Rated fragment activity
            return new second();
        case 1:
            // Games fragment activity
            return new third();
        case 2:
            // Movies fragment activity
            return new forth();
        }
 
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }
 
}