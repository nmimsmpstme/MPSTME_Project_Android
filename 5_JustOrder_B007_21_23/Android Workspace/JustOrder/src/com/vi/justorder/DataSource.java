package com.vi.justorder;

import java.util.ArrayList;

public class DataSource {
    private ArrayList<Integer> mPhotoPool;
    private ArrayList<Integer> mMenuPool;
    private ArrayList<Integer> mPhotoHdPool;

    public ArrayList<Integer> getmPhotoHdPool() {
        return mPhotoHdPool;
    }

    public ArrayList<Integer> getmPhotoPool() {
        return mPhotoPool;
    }

    public ArrayList<Integer> getmMenuPool() {
        return mMenuPool;
    }

    private void setupPhotoPool() {
        mPhotoPool.add(R.drawable.menu1);
        mPhotoPool.add(R.drawable.menu2);
        mPhotoPool.add(R.drawable.menu3);
        mPhotoPool.add(R.drawable.menu4);
        mPhotoPool.add(R.drawable.menu5);
        mPhotoPool.add(R.drawable.menu6);
        mPhotoPool.add(R.drawable.menu7);
        mPhotoPool.add(R.drawable.menu8);
        mPhotoPool.add(R.drawable.menu9);
        mPhotoPool.add(R.drawable.menu10);
    }

    private void setupMenuPool() {
        mMenuPool.add(R.string.menu_1);
        mMenuPool.add(R.string.menu_2);
        mMenuPool.add(R.string.menu_3);
        mMenuPool.add(R.string.menu_4);
        mMenuPool.add(R.string.menu_5);
        mMenuPool.add(R.string.menu_6);
        mMenuPool.add(R.string.menu_7);
        mMenuPool.add(R.string.menu_8);
        mMenuPool.add(R.string.menu_9);
        mMenuPool.add(R.string.menu_10);
    }

    private void setupPhotoHDPool() {
        mPhotoHdPool.add(R.drawable.menu1);
        mPhotoHdPool.add(R.drawable.menu2);
        mPhotoHdPool.add(R.drawable.menu3);
        mPhotoHdPool.add(R.drawable.menu4);
        mPhotoHdPool.add(R.drawable.menu5);
        mPhotoHdPool.add(R.drawable.menu6);
        mPhotoHdPool.add(R.drawable.menu7);
        mPhotoHdPool.add(R.drawable.menu8);
        mPhotoHdPool.add(R.drawable.menu9);
        mPhotoHdPool.add(R.drawable.menu10);
    }

    public int getDataSourceLength() {
        return mPhotoPool.size();
    }

    public DataSource() {
        mPhotoPool = new ArrayList();
        mMenuPool = new ArrayList();
        mPhotoHdPool = new ArrayList();
        setupPhotoPool();
        setupMenuPool();
        setupPhotoHDPool();
    }
}
