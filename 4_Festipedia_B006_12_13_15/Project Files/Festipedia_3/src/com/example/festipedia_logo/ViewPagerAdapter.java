package com.example.festipedia_logo;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.widget.TextView;
 
public class ViewPagerAdapter extends FragmentPagerAdapter {
 
    // Declare the number of ViewPager pages
    final int PAGE_COUNT = 2;
    //String a;
    private String titles[] = new String[] { "Event Details", "Location" };
    String val[]=new String[8];
    public ViewPagerAdapter(FragmentManager fm,String []b) {
        super(fm);
        val=b;
    }
 
    @Override
    public Fragment getItem(int position) {
        switch (position) {
 
            // Open FragmentTab1.java
        case 0:
            FragmentTab1 fragmenttab1 = new FragmentTab1(val);
           // Log.d("yo",val[1]);
            return fragmenttab1;
 
            // Open FragmentTab2.java
        case 1:
            FragmentTab2 fragmenttab2 = new FragmentTab2(val[7]);
            //Log.d("val","Hello"+val[7]);
            return fragmenttab2;
        }
        return null;
    }
 
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
 
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
 
}