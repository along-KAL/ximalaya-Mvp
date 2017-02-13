package com.example.kongalong.ximalaya_mvp.module.discover;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Scroller;
import android.widget.TextView;

import com.example.kongalong.ximalaya_mvp.MyApp;
import com.example.kongalong.ximalaya_mvp.R;
import com.example.kongalong.ximalaya_mvp.imageLoad.SampleImageLoad;
import com.example.kongalong.ximalaya_mvp.adapters.AdvPagerAdapter;
import com.example.kongalong.ximalaya_mvp.adapters.RecommendListAdapter;
import com.example.kongalong.ximalaya_mvp.adapters.RecommendPagerAdapter1;
import com.example.kongalong.ximalaya_mvp.base.BaseFragment;
import com.example.kongalong.ximalaya_mvp.model.RecommendBeans1;
import com.example.kongalong.ximalaya_mvp.model.RecommendBeans2;
import com.example.kongalong.ximalaya_mvp.model.RecommendBeans3;
import com.example.kongalong.ximalaya_mvp.presenter.RecommendFragmentPresenter;
import com.example.kongalong.ximalaya_mvp.utils.ImageLoadUtil;
import com.example.kongalong.ximalaya_mvp.utils.ViewPagerUtil;
import com.example.kongalong.ximalaya_mvp.view.RecommendListViewView;
import com.example.kongalong.ximalaya_mvp.widget.CustomIndicator;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends BaseFragment implements
        Handler.Callback, RecommendListViewView {


    private ListView mRecommendListView;
    private RecommendListAdapter mRecommendListAdapter;

    private ViewPager mListViewHeaderViewPager1;
    private ViewPager mListViewHeaderViewPager2;

    private ViewPager mListViewFooterViewPager;

    private PagerAdapter mHeaderPagerAdapter1;
    private PagerAdapter mHeaderPagerAdapter2;

    private PagerAdapter mFooterPagerAdapter;

    private PullToRefreshListView mPullToRefreshListView;

    private CustomIndicator mHeaderCustomIndicator1;
    private CustomIndicator mHeaderCustomIndicator2;

    private CustomIndicator mFooterCustomIndicator;

    private List<View> mHeaderPagerData1;
    private List<View> mHeaderPagerData2;

    private List<View> mFooterPagerData;

    private List<Object> mRecommendlistData;

    private SampleImageLoad mSampleImageLoad ;

    private int mCurrentPosition;
    private Handler mHandler;


    //
    RecommendFragmentPresenter mRecommendFragmentPresenter;



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void initViewAndEvent(View ret) {

        mHandler = new Handler(this);

        initListView(ret);

        initHeaderFooterViewPager();

        initViewPagerListener();

        initListViewOnScrollListener();

        //关联presenter和view
        mRecommendFragmentPresenter = new RecommendFragmentPresenter(this.getContext());
        mRecommendFragmentPresenter.attachView(this);

        //通过presenter加载数据
        mRecommendFragmentPresenter.loadData();

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initListViewOnScrollListener() {

        mRecommendListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if(scrollState==SCROLL_STATE_IDLE){
                   // mRecommendListAdapter.setIsScroll(false);
                    //mRecommendListAdapter.notifyDataSetChanged();
                }else{
                   // mRecommendListAdapter.setIsScroll(true);
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    @TargetApi(M)
    private void initViewPagerListener() {

        mCurrentPosition = Integer.MAX_VALUE/2;

        mListViewHeaderViewPager1.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {

                mHeaderCustomIndicator1.setMoveX(position% mHeaderPagerData1.size(),
                        positionOffset);
            }

            @Override
            public void onPageSelected(int position) {
                //Log.d("flag", "onPageSelected: " +position);
                 mHandler.sendMessage(mHandler.obtainMessage(3,position,0,null));

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch(state){
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        mHandler.sendEmptyMessage(2);
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        mHandler.sendEmptyMessageDelayed(1,2000);
                        break;
                }
            }
        });
        //开始轮播效果
        mHandler.sendEmptyMessageDelayed(1, 2000);
        mListViewHeaderViewPager2.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {

                mHeaderCustomIndicator2.setMoveX(position%3,positionOffset);
            }
            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    private void initHeaderFooterViewPager() {

        //header1
        mHeaderPagerData1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(R.mipmap.ic_launcher);
            mHeaderPagerData1.add(imageView);
        }
        mHeaderCustomIndicator1.setCount(10);

        mHeaderPagerAdapter1 = new RecommendPagerAdapter1(mHeaderPagerData1);
        mListViewHeaderViewPager1.setAdapter(mHeaderPagerAdapter1);

        mListViewHeaderViewPager1.setCurrentItem(Integer.MAX_VALUE/2);


        ViewPagerScroller mPagerScroller=new ViewPagerScroller(getActivity());
        mPagerScroller.initViewPagerScroll(mListViewHeaderViewPager1);
        //header2
        mHeaderPagerData2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            View view = LayoutInflater.from(getActivity()).inflate
                    (R.layout.recommend_list_header2_layout,
                            mListViewHeaderViewPager2, false);

            mHeaderPagerData2.add(view);

        }

        mHeaderCustomIndicator2.setCount(3);
         mHeaderPagerAdapter2 = new AdvPagerAdapter(mHeaderPagerData2);
         mListViewHeaderViewPager2.setAdapter(mHeaderPagerAdapter2);


        //footer
        mFooterPagerData = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(R.mipmap.ic_launcher);
            mFooterPagerData.add(imageView);
        }
        mFooterCustomIndicator.setCount(3);

        mFooterPagerAdapter = new AdvPagerAdapter(mFooterPagerData);
        mListViewFooterViewPager.setAdapter(mFooterPagerAdapter);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void initListView(View view) {

        //mRecommendListView = (ListView) view.findViewById(R.id.recommend_list);

        mPullToRefreshListView = (PullToRefreshListView) view.findViewById
                (R.id.recommend_pulltoreflesh);
        //从pullToReflesh获得listview
        mRecommendListView = mPullToRefreshListView.getRefreshableView();
        //头布局
        View header = LayoutInflater.from(getContext()).inflate
                (R.layout.recommend_list_header, mRecommendListView, false);
        //头布局中的viewpager1
        mListViewHeaderViewPager1 = (ViewPager) header
                .findViewById(R.id.recommend_list_header_viewpager1);
        //头布局中的viewpager2
        mListViewHeaderViewPager2 = (ViewPager) header
                .findViewById(R.id.recommend_list_header_viewpager2);

        //尾布局
        View footer = LayoutInflater.from(getContext()).inflate
                (R.layout.advertisement_list_footer, mRecommendListView, false);

        //尾布局中的viewpager
        mListViewFooterViewPager = (ViewPager) footer.findViewById(R.id.advertisement_list_footer_pager);



        //头布局中的viewpager指示器
        mHeaderCustomIndicator1 = (CustomIndicator) header.findViewById(R.id.indicator1);
        mHeaderCustomIndicator2 = (CustomIndicator) header.findViewById(R.id.indicator2);
        //尾布局中的viewpager指示器
        mFooterCustomIndicator = (CustomIndicator) footer.findViewById(R.id.indicator3);

        TextView emptyView = (TextView) view.findViewById(R.id.emptyView);

        //listView中的数据
        mRecommendlistData = new ArrayList<>();
        //添加头尾布局
        mRecommendListView.addHeaderView(header);
        mRecommendListView.addFooterView(footer);
        //设置适配器
        mRecommendListAdapter = new RecommendListAdapter(getActivity(), mRecommendlistData);

        mRecommendListView.setEmptyView(emptyView);

        mRecommendListView.setAdapter(mRecommendListAdapter);


    }


    @Override
    protected void initData() {


    }
    //初始化图片加载工具
    @Override
    protected void initSampleImageLoad() {
        mSampleImageLoad = ((MyApp) getActivity().getApplication()).getSampleImageLoad();
    }


    //通过presenter完成数据请求后调用
    @Override
    public void refleshData(RecommendBeans1 recommendBeans1
    ,RecommendBeans2 recommendBeans2,RecommendBeans3 recommendBeans3){

        //从RecommendBeans1取出imageUrl
        List<RecommendBeans1.FocusImagesBean.ListBean> header1ListBean
                = recommendBeans1.getFocusImages().getList();
        List<String> header1UrlList = new ArrayList<>();
        for (int i = 0; i < header1ListBean.size(); i++) {
            header1UrlList.add(header1ListBean.get(0).getPic());
        }

        //从RecommendBeans3取出imageUrl
        List<RecommendBeans3.DataBean> footerListBean
                = recommendBeans3.getData();
        List<String> footerUrlList = new ArrayList<>();
        for (int i = 0; i < footerListBean.size(); i++) {
            footerUrlList.add(recommendBeans3.getData().get(i).getCover());
        }

        //刷新头布局viewpager数据
        ViewPagerUtil.refleshPagerData(getContext()
                ,header1UrlList
                ,mHeaderPagerData1
                ,mHeaderCustomIndicator1
                ,mSampleImageLoad
                ,mHeaderPagerAdapter1);

        //刷新尾布局广告viewpager数据
        ViewPagerUtil.refleshPagerData(getContext()
                ,footerUrlList
                ,mFooterPagerData
                ,mFooterCustomIndicator
                ,mSampleImageLoad
                ,mFooterPagerAdapter);

        //刷新头布局viewpager2数据
        refleshHeaderPagerData2(recommendBeans1);

        //刷新listView数据
        refleshRecommendListViewData(recommendBeans1,recommendBeans2);
    }



    private void refleshRecommendListViewData(RecommendBeans1 recommendBeans1, RecommendBeans2 recommendBeans2) {

        List<RecommendBeans2.GuessBean.ListBean> guessList =
                recommendBeans2.getGuess().getList();

        List<RecommendBeans1.EditorRecommendAlbumsBean.ListBean> editRecommend =
                recommendBeans1.getEditorRecommendAlbums().getList();

        List<RecommendBeans2.HotRecommendsBean.ListBean> normalList =
                recommendBeans2.getHotRecommends().getList();

        List<RecommendBeans1.SpecialColumnBean.ListBean> speciaList =
                recommendBeans1.getSpecialColumn().getList();

        mRecommendlistData.add(0, guessList);
        mRecommendlistData.add(1, editRecommend);
        mRecommendlistData.add(2,speciaList);
        mRecommendlistData.addAll(normalList);

        mRecommendListAdapter.notifyDataSetChanged();


    }

    private void refleshHeaderPagerData2(RecommendBeans1 mRecommendBeans1) {

        List<RecommendBeans1.DiscoveryColumnsBean.ListBean> pagerDatabeans = mRecommendBeans1
                .getDiscoveryColumns().getList();


        int index = -1;
        for (int i = 0; i < mHeaderPagerData2.size(); i++) {

            View view = mHeaderPagerData2.get(i);

            ImageView imageView1 = (ImageView) view.findViewById(R.id.recommend_list_header2_image1);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.recommend_list_header2_image2);
            ImageView imageView3 = (ImageView) view.findViewById(R.id.recommend_list_header2_image3);
            ImageView imageView4 = (ImageView) view.findViewById(R.id.recommend_list_header2_image4);

            TextView textView1 = (TextView) view.findViewById(R.id.recommend_list_header2_text1);
            TextView textView2 = (TextView) view.findViewById(R.id.recommend_list_header2_text2);
            TextView textView3 = (TextView) view.findViewById(R.id.recommend_list_header2_text3);
            TextView textView4 = (TextView) view.findViewById(R.id.recommend_list_header2_text4);

            LinearLayout linearLayout1 = (LinearLayout) view.findViewById(R.id.recommend_text_image1);
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.recommend_text_image2);
            LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.recommend_text_image3);
            LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.recommend_text_image4);


            if(index==pagerDatabeans.size()-1){
                linearLayout1.setVisibility(View.INVISIBLE);
                linearLayout2.setVisibility(View.INVISIBLE);
                linearLayout3.setVisibility(View.INVISIBLE);
                linearLayout4.setVisibility(View.INVISIBLE);
                break;
            }
            ImageLoadUtil.showImage(mSampleImageLoad,pagerDatabeans.get(++index).getCoverPath(),imageView1);
            textView1.setText(pagerDatabeans.get(index).getTitle());
            if(index==pagerDatabeans.size()-1){
                linearLayout2.setVisibility(View.INVISIBLE);
                linearLayout3.setVisibility(View.INVISIBLE);
                linearLayout4.setVisibility(View.INVISIBLE);
                break;
            }
            ImageLoadUtil.showImage(mSampleImageLoad,pagerDatabeans.get(++index).getCoverPath(), imageView2);
            textView2.setText(pagerDatabeans.get(index).getTitle());
            if(index==pagerDatabeans.size()-1){
                linearLayout3.setVisibility(View.INVISIBLE);
                linearLayout4.setVisibility(View.INVISIBLE);
                break;
            }
            ImageLoadUtil.showImage(mSampleImageLoad,pagerDatabeans.get(++index).getCoverPath(), imageView3);
            textView3.setText(pagerDatabeans.get(index).getTitle());
            if(index==pagerDatabeans.size()-1){
                linearLayout4.setVisibility(View.INVISIBLE);
                break;
            }
            ImageLoadUtil.showImage(mSampleImageLoad,pagerDatabeans.get(++index).getCoverPath(), imageView4);
            textView4.setText(pagerDatabeans.get(index).getTitle());
        }

    }




    //实现无线轮播
    @Override
    public boolean handleMessage(Message msg) {
        //Log.d("flag", "handleMessage: " + msg.what);
            switch(msg.what) {
                case 1:
                    if (mHandler.hasMessages(1)) {
                        mHandler.removeMessages(1);
                    }
                    mCurrentPosition++;
                    //Log.d("flag", "handleMessage: " +mCurrentPosition);
                    mListViewHeaderViewPager1.setCurrentItem(mCurrentPosition,true);
                   // mHandler.sendEmptyMessageDelayed(1, 2000);
                  //  Log.d("flag", "handleMessage: " +mCurrentPosition);
                    break;
                case 2:
                    mHandler.removeMessages(1);
                    break;
                case 3:
                    mCurrentPosition = msg.arg1;
                    //mListViewHeaderViewPager1.setCurrentItem(++mCurrentPosition);
                    //mHandler.sendEmptyMessageDelayed(1, 2000);
                    break;
            }
        return true;
    }

    public class ViewPagerScroller extends Scroller {

        private int mScrollDuration = 800; // 滑动速度

        /**
         * 设置速度速度
         *
         * @param duration
         */
        public void setScrollDuration(int duration) {
            this.mScrollDuration = duration;
        }

        public ViewPagerScroller(Context context) {
            super(context);
        }

        public ViewPagerScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        @SuppressLint("NewApi")
        public ViewPagerScroller(Context context, Interpolator interpolator,
                                 boolean flywheel) {
            super(context, interpolator, flywheel);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, mScrollDuration);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy) {
            super.startScroll(startX, startY, dx, dy, mScrollDuration);
        }

        public void initViewPagerScroll(ViewPager viewPager) {
            try {
                Field mScroller = ViewPager.class.getDeclaredField("mScroller");
                mScroller.setAccessible(true);
                mScroller.set(viewPager, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
