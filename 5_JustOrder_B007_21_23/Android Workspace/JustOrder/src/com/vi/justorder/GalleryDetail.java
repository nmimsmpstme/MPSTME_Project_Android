package com.vi.justorder;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GalleryDetail extends Activity {

    private ImageView mImageView;
    private TextView mMenu;
    private int mPosition;
    private DataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_detail);

        Intent i = getIntent();
        mPosition = i.getIntExtra("position", 0);

        mDataSource = new DataSource();
        mImageView = (ImageView) findViewById(R.id.image);
        mMenu = (TextView) findViewById(R.id.menus);

        mImageView.setImageResource(mDataSource.getmPhotoHdPool().get(mPosition));
        mMenu.setText(getResources().getString(mDataSource.getmMenuPool().get(mPosition)));
    }
}