package com.example.kongalong.ximalaya_mvp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by kongalong on 2016/11/9.
 */
public class DiscoverViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mDiscoverDatas;
    private String[] mTitles;

    public DiscoverViewPagerAdapter(FragmentManager supportFragmentManager, List<Fragment> discoverDatas, String[] tiltes) {
        super(supportFragmentManager);

        this.mDiscoverDatas = discoverDatas;
        this.mTitles = tiltes;
    }

    @Override
    public Fragment getItem(int position) {
        return mDiscoverDatas.get(position);
    }

    @Override
    public int getCount() {
        return mDiscoverDatas!=null?mDiscoverDatas.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
