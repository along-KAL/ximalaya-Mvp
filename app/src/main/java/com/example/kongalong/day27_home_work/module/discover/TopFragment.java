package com.example.kongalong.day27_home_work.module.discover;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kongalong.day27_home_work.MyApp;
import com.example.kongalong.day27_home_work.R;
import com.example.kongalong.day27_home_work.SampleImageLoad.SampleImageLoad;
import com.example.kongalong.day27_home_work.adapters.TopListAdapter;
import com.example.kongalong.day27_home_work.base.BaseFragment;
import com.example.kongalong.day27_home_work.model.TopBeans;
import com.example.kongalong.day27_home_work.presenter.TopFragmentPresenter;
import com.example.kongalong.day27_home_work.utils.ImageLoadUtil;
import com.example.kongalong.day27_home_work.view.TopListViewView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends BaseFragment implements TopListViewView {

    private SampleImageLoad mSampleImageLoad;

    private ListView mTopFragmentList;

    private BaseAdapter mTopListAdapter;

    private List<TopBeans.DatasBean> data;


    private TopFragmentPresenter mTopFragmentPresenter;

    private ImageView mHeaderImage;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_top;
    }

    @Override
    protected void initViewAndEvent(View ret) {

        initListView(ret);


        //关联presenter和view
        mTopFragmentPresenter = new TopFragmentPresenter(this.getContext());
        mTopFragmentPresenter.attachView(this);

        //通过presenter加载数据
        mTopFragmentPresenter.loadData();
    }


    private void initListView(View view) {

        TextView emptyView= (TextView) view.findViewById(R.id.emptyView);

        mTopFragmentList = (ListView) view.findViewById(R.id.top_list);
        //头布局
        View header = LayoutInflater.from(getContext()).inflate(R.layout.top_header,mTopFragmentList,false);

        View footer = LayoutInflater.from(getContext())
                .inflate(R.layout.list_view_footer,mTopFragmentList,false);

        mHeaderImage = (ImageView) header.findViewById(R.id.top_header_image);

        mTopFragmentList.addHeaderView(header);

        mTopFragmentList.addFooterView(footer);

        data = new ArrayList<>();

        mTopListAdapter = new TopListAdapter(getContext(),data);

        mTopFragmentList.setEmptyView(emptyView);

        mTopFragmentList.setAdapter(mTopListAdapter);

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
    public void refleshData(TopBeans topBeans) {

        //更新头布局
        ImageLoadUtil.showImage(mSampleImageLoad
                ,topBeans.getFocusImages().getList().get(0).getPic()
                ,mHeaderImage);
        //更新list
        List<TopBeans.DatasBean> list = topBeans.getDatas();

        data.addAll(list);

        mTopListAdapter.notifyDataSetChanged();
    }
}
