package com.vi.justorder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Gallery extends Activity {

    public class MenuAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater mInflator;
        private DataSource mDataSource;

        public MenuAdapter(Context c) {
            mContext = c;
            mInflator = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mDataSource = new DataSource();
        }

        @Override
        public int getCount() {
            return mDataSource.getDataSourceLength();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView thumbnail;
            TextView Menu;

            if(convertView == null) {
                convertView = mInflator.inflate(R.layout.list_item_layout, parent, false);
            }

            thumbnail = (ImageView) convertView.findViewById(R.id.thumb);
            thumbnail.setImageResource(mDataSource.getmPhotoPool().get(position));
            Menu = (TextView) convertView.findViewById(R.id.text);
            Menu.setText(mDataSource.getmMenuPool().get(position));
            return convertView;
        }
    }

    // Rest of MenuReaderActivty class...

    private ListView mListView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_main);
        mListView = (ListView) findViewById(R.id.menu_list);
        mListView.setAdapter(new MenuAdapter(this));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                    long arg3) {
                Intent i = new Intent(Gallery.this, GalleryDetail.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        });
    }
}
