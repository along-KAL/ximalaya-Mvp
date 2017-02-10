package com.example.kongalong.ximalaya_mvp.adapters;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

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

       // container.removeView(mPagerData1.get(position%mPagerData1.size()));
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        //对ViewPager页号求模取出View列表中要显示的项
        position %= mPagerData1.size();
        if (position<0){
            position = mPagerData1.size()+position;
        }
        View view = mPagerData1.get(position);
        //如果View已经在之前添加到了一个父组件，则必须先remove，否则会抛出IllegalStateException。
        ViewParent vp =view.getParent();
        if (vp!=null){
            ViewGroup parent = (ViewGroup)vp;
            parent.removeView(view);
        }
        container.addView(view);
        //add listeners here if necessary
        return view;
       /* if(mPagerData1.get(position%mPagerData1.size()).getParent()==null){

            container.addView(mPagerData1.get(position%mPagerData1.size()));
        }
       // Log.d("flag", "instantiateItem: " +position%mPagerData1.size());
        return mPagerData1.get(position%mPagerData1.size());*/
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
