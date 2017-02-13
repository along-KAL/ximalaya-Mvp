package com.example.kongalong.ximalaya_mvp.module.discover;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kongalong.ximalaya_mvp.MyApp;
import com.example.kongalong.ximalaya_mvp.R;
import com.example.kongalong.ximalaya_mvp.imageLoad.SampleImageLoad;
import com.example.kongalong.ximalaya_mvp.adapters.BroadcastListAdapter;
import com.example.kongalong.ximalaya_mvp.base.BaseFragment;
import com.example.kongalong.ximalaya_mvp.model.BroadcastBeans;
import com.example.kongalong.ximalaya_mvp.presenter.BroadcastFragmentPresenter;
import com.example.kongalong.ximalaya_mvp.view.BroadcastListViewView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BroadcastFragment extends BaseFragment
        implements BroadcastListViewView {

    private SampleImageLoad mSampleImageLoad;

    private ListView mBroadcastFragmentList;

    private BaseAdapter mBroadcastListAdapter;

    private List<Object> data;

    private BroadcastFragmentPresenter mBroadcastFragmentPresenter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_broadcast;
    }

    @Override
    protected void initViewAndEvent(View ret) {

        initListView(ret);


        //关联presenter和view
        mBroadcastFragmentPresenter = new BroadcastFragmentPresenter(this.getContext());
        mBroadcastFragmentPresenter.attachView(this);

        //通过presenter加载数据
        mBroadcastFragmentPresenter.loadData();
    }


    private void initListView(View view) {

        TextView emptyView= (TextView) view.findViewById(R.id.emptyView);

        mBroadcastFragmentList = (ListView) view.findViewById(R.id.broadcast_list);

        View footer = LayoutInflater.from(getContext())
                .inflate(R.layout.list_view_footer,mBroadcastFragmentList,false);

        data = new ArrayList<>();

        mBroadcastListAdapter = new BroadcastListAdapter(getContext(),data);

        mBroadcastFragmentList.setEmptyView(emptyView);

        mBroadcastFragmentList.addFooterView(footer);

        mBroadcastFragmentList.setAdapter(mBroadcastListAdapter);

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
    public void refleshData(BroadcastBeans broadcastBeans) {

        //更新list
        List<BroadcastBeans.ResultBean.RecommandRadioListBean> recommandRadioList
                = broadcastBeans.getResult().getRecommandRadioList();

        List<BroadcastBeans.ResultBean.TopRadioListBean> topRadioList
                = broadcastBeans.getResult().getTopRadioList();

        data.add(null);
        data.add(recommandRadioList);
        data.add(topRadioList);

        mBroadcastListAdapter.notifyDataSetChanged();
    }
}