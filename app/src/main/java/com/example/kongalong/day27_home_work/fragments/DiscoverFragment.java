package com.example.kongalong.day27_home_work.fragments;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.kongalong.day27_home_work.R;
import com.example.kongalong.day27_home_work.adapters.DiscoverViewPagerAdapter;
import com.example.kongalong.day27_home_work.base.BaseFragment;
import com.example.kongalong.day27_home_work.module.discover.AnchorFragment;
import com.example.kongalong.day27_home_work.module.discover.BroadcastFragment;
import com.example.kongalong.day27_home_work.module.discover.ClassifyFragment;
import com.example.kongalong.day27_home_work.module.discover.ListFragment;
import com.example.kongalong.day27_home_work.module.discover.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends BaseFragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<Fragment> mDiscoverDatas;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discover;
    }




    @Override
    protected void initViewAndEvent(View ret) {

        mTabLayout = (TabLayout) ret.findViewById(R.id.discover_tab_layout);
        mViewPager = (ViewPager) ret.findViewById(R.id.discover_view_pager);

    }

    @Override
    protected void initData() {

        mDiscoverDatas = new ArrayList<>();

        mDiscoverDatas.add(new RecommendFragment());
        mDiscoverDatas.add(new ClassifyFragment());
        mDiscoverDatas.add(new BroadcastFragment());
        mDiscoverDatas.add(new ListFragment());
        mDiscoverDatas.add(new AnchorFragment());

        String[] tiltes = getActivity().getResources().getStringArray(R.array.discoverTitle);

        FragmentManager supportFragmentManager = getActivity().
                getSupportFragmentManager();

        FragmentPagerAdapter adapter = new DiscoverViewPagerAdapter
                (supportFragmentManager,mDiscoverDatas,tiltes);

        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    protected void initSampleImageLoad() {

    }

}
