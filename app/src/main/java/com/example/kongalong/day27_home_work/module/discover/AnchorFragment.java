package com.example.kongalong.day27_home_work.module.discover;


import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kongalong.day27_home_work.MyApp;
import com.example.kongalong.day27_home_work.R;
import com.example.kongalong.day27_home_work.SampleImageLoad.SampleImageLoad;
import com.example.kongalong.day27_home_work.adapters.AnchorListAdapter;
import com.example.kongalong.day27_home_work.base.BaseFragment;
import com.example.kongalong.day27_home_work.model.AnchorBeans;
import com.example.kongalong.day27_home_work.presenter.AnchorFragmentPresenter;
import com.example.kongalong.day27_home_work.view.AnchorListViewView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnchorFragment extends BaseFragment implements AnchorListViewView {

    private SampleImageLoad mSampleImageLoad;

    private ListView mAnchorFragmentList;

    private BaseAdapter mAnchorListAdapter;

    private List<AnchorBeans.ListBean> data;

    private AnchorFragmentPresenter mAnchorFragmentPresenter;

    private PullToRefreshListView mPullToRefreshListView;


    private int pageIndex = 1;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_anchor;
    }

    @Override
    protected void initViewAndEvent(View ret) {

        initListView(ret);


        //关联presenter和view
        mAnchorFragmentPresenter = new AnchorFragmentPresenter(this.getContext());
        mAnchorFragmentPresenter.attachView(this);

        //通过presenter加载数据
        mAnchorFragmentPresenter.loadData(pageIndex);

        initPullToRefleshEvent();
    }

    private void initPullToRefleshEvent() {

        mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //通过presenter刷新数据
                Log.d("flag", "onPullUpToRefresh: "+ (++pageIndex));
                mAnchorFragmentPresenter.loadData(++pageIndex);

                mPullToRefreshListView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshListView.onRefreshComplete();
                    }
                },2000);
            }
        });

    }


    private void initListView(View view) {

        TextView emptyView= (TextView) view.findViewById(R.id.emptyView);

        mPullToRefreshListView = (PullToRefreshListView) view
                .findViewById(R.id.anchor_pulltoreflesh);

        mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);


        mAnchorFragmentList = mPullToRefreshListView.getRefreshableView();

        View footer = LayoutInflater.from(getContext())
                .inflate(R.layout.list_view_footer,mAnchorFragmentList,false);

        data = new ArrayList<>();

        mAnchorListAdapter = new AnchorListAdapter(getContext(),data);

        mAnchorFragmentList.setEmptyView(emptyView);

        mAnchorFragmentList.addFooterView(footer);

        mAnchorFragmentList.setAdapter(mAnchorListAdapter);

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
    public void refleshData(AnchorBeans anchorBeans) {

        data.addAll(anchorBeans.getList());

        mAnchorListAdapter.notifyDataSetChanged();
    }
}
