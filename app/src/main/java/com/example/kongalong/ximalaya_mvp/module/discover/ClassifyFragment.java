package com.example.kongalong.ximalaya_mvp.module.discover;


import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kongalong.ximalaya_mvp.MyApp;
import com.example.kongalong.ximalaya_mvp.R;
import com.example.kongalong.ximalaya_mvp.imageLoad.SampleImageLoad;
import com.example.kongalong.ximalaya_mvp.adapters.AdvPagerAdapter;
import com.example.kongalong.ximalaya_mvp.adapters.ClassifyListAdapter;
import com.example.kongalong.ximalaya_mvp.base.BaseFragment;
import com.example.kongalong.ximalaya_mvp.model.ClassifyAdvBeans;
import com.example.kongalong.ximalaya_mvp.model.ClassifyBeans;
import com.example.kongalong.ximalaya_mvp.presenter.ClassifyFragmentPresenter;
import com.example.kongalong.ximalaya_mvp.utils.ImageLoadUtil;
import com.example.kongalong.ximalaya_mvp.utils.ViewPagerUtil;
import com.example.kongalong.ximalaya_mvp.view.ClassifyListViewView;
import com.example.kongalong.ximalaya_mvp.widget.CustomIndicator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFragment extends BaseFragment implements ClassifyListViewView{

    private SampleImageLoad mSampleImageLoad;

    private ListView mClassifyFragmentList;

    private BaseAdapter mClassifyListAdapter;

    private List<Map<Integer,ClassifyBeans.ListBean>> data;


    private List<View> mFooterPagerData;

    private PagerAdapter mFooterPagerAdapter;

    private ViewPager mListViewFooterViewPager;

    private CustomIndicator mFooterCustomIndicator;


    private ClassifyFragmentPresenter mClassifyFragmentPresenter;
    private ImageView mHeaderImage;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classify;
    }

    @Override
    protected void initViewAndEvent(View ret) {

        initListView(ret);

        initListFooter();

        initFooterPagerOnScroll();

        //关联presenter和view
        mClassifyFragmentPresenter = new ClassifyFragmentPresenter(this.getContext());
        mClassifyFragmentPresenter.attachView(this);

        //通过presenter加载数据
        mClassifyFragmentPresenter.loadData();
    }

    private void initFooterPagerOnScroll() {
        mListViewFooterViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mFooterCustomIndicator.setMoveX(position,
                        positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initListFooter() {

        //footer
        mFooterPagerData = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(R.mipmap.ic_launcher);
            mFooterPagerData.add(imageView);
        }
        mFooterCustomIndicator.setCount(4);

        mFooterPagerAdapter = new AdvPagerAdapter(mFooterPagerData);
        mListViewFooterViewPager.setAdapter(mFooterPagerAdapter);

    }

    private void initListView(View view) {

        TextView emptyView= (TextView) view.findViewById(R.id.emptyView);

        mClassifyFragmentList = (ListView) view.findViewById(R.id.classify_list);
        //头布局
        View header = LayoutInflater.from(getContext()).inflate(R.layout.classify_header,mClassifyFragmentList,false);

        mHeaderImage = (ImageView) header.findViewById(R.id.classify_header_image);

        //尾布局
        View footer = LayoutInflater.from(getContext()).inflate
                (R.layout.advertisement_list_footer, mClassifyFragmentList, false);

        footer.findViewById(R.id.find_classify_layout).setVisibility(View.GONE);

        mListViewFooterViewPager = (ViewPager) footer.findViewById(R.id.advertisement_list_footer_pager);

        mFooterCustomIndicator = (CustomIndicator) footer.findViewById(R.id.indicator3);

        mClassifyFragmentList.addHeaderView(header);

        mClassifyFragmentList.addFooterView(footer);

        data = new ArrayList<>();

        mClassifyListAdapter = new ClassifyListAdapter(getContext(),data);

        mClassifyFragmentList.setEmptyView(emptyView);

        mClassifyFragmentList.setAdapter(mClassifyListAdapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initSampleImageLoad() {
        mSampleImageLoad = ((MyApp)getActivity()
                .getApplication()).getSampleImageLoad();
    }

    @Override
    public void refleshData(ClassifyBeans classifyBeans
            , ClassifyAdvBeans classifyAdvBeans) {

        //从classifyBeans取出imageUrl
        List<ClassifyAdvBeans.DataBean> footerListBean
                = classifyAdvBeans.getData();
        List<String> footerUrlList = new ArrayList<>();
        for (int i = 0; i < footerListBean.size(); i++) {
            footerUrlList.add(footerListBean.get(i).getCover());
        }

        //刷新尾布局广告viewpager数据
        ViewPagerUtil.refleshPagerData(getContext()
                ,footerUrlList
                ,mFooterPagerData
                ,mFooterCustomIndicator
                ,mSampleImageLoad
                ,mFooterPagerAdapter);




        List<ClassifyBeans.ListBean> list = classifyBeans.getList();
        //更新头布局
        ImageLoadUtil.showImage(mSampleImageLoad,list.get(0).getCoverPath(),mHeaderImage);
        //包装数据
        List<Map<Integer,ClassifyBeans.ListBean>> listMap = new ArrayList<>();
        int count = 0;

        for (int i = 1; i < list.size(); ) {

            Map<Integer,ClassifyBeans.ListBean> map = new HashMap<>();
            for (int j = 0; j < 6; j++) {

                if (i+j>=list.size()) {
                    map.put(j,null);
                    continue;
                }
                map.put(j, list.get(i+j));
            }
            listMap.add(map);
            i += 6;
        }

        data.addAll(listMap);

        mClassifyListAdapter.notifyDataSetChanged();
    }
}
