package com.example.myfilofax;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
 
    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.add, R.drawable.camera,
            R.drawable.click, R.drawable.delete,
            R.drawable.exams, R.drawable.ip,
            R.drawable.lum, R.drawable.requests,
            R.drawable.share, R.drawable.tasks
           
    };
 
    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }
 


	@Override
    public int getCount() {
        return mThumbIds.length;
    }
 
    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }
 
    @Override
    public long getItemId(int position) {
        return 0;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;
    }
 
}
