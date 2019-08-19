package com.example.registerapp;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ListFragment listFragment = new ListFragment();
                return listFragment;
            case 1:
                GalleryFragment galleryFragment = new GalleryFragment();
                return galleryFragment;
            case 2:
                CallFragment callFragment = new CallFragment();
                return callFragment;
            case 3:
                DetailFragment detailFragment = new DetailFragment();
                return detailFragment;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }

}
