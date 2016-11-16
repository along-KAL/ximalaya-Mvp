package com.example.kongalong.day27_home_work.adapters;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by kongalong on 2016/11/10.
 */
public class RecommendPagerAdapter1 extends PagerAdapter {

    private List<View>mPagerData1;

    public RecommendPagerAdapter1(List<View> pagerData1) {
        this.mPagerData1 = pagerData1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(mPagerData1.get(position%mPagerData1.size()));
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        if(mPagerData1.get(position%mPagerData1.size()).getParent()==null){
            container.addView(mPagerData1.get(position%mPagerData1.size()));
        }

        return mPagerData1.get(position%mPagerData1.size());
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
